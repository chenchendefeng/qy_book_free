package com.only.tech.admin.common.interceptor;

import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.time.ZoneId;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.only.tech.base.SuperEntity;
import com.only.tech.base.SuperEntityWithIntegerID;
import com.only.tech.dto.admin.UserAdminDto;
import com.only.tech.entity.admin.ALog;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import com.only.tech.admin.service.biz.IALogService;
import com.only.tech.admin.common.targetMethod.RecordLog;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
@Component
public class HandleLogAnnotation {
	@Autowired
	private IALogService iALogService;
	
	
	// 定义一个公用方法
	@Pointcut("@annotation(com.only.tech.admin.common.targetMethod.RecordLog)")
	public void log() {
	}

	@AfterReturning(returning = "obj", pointcut = "log()")
	public void doAfterReturnig(JoinPoint joinPoint ,Object obj) {
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();
		HttpSession session = request.getSession();
		if(session == null)
		{
			log.error("no session to handle");
			return ;
		}
		UserAdminDto user = (UserAdminDto) session.getAttribute("user");
		if(user == null)
		{
			log.error("no user in session");
			return ;
		}
		Integer id = user.getId();
		String userName = user.getUserName();
		
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();

        RecordLog syslog = method.getAnnotation(RecordLog.class);
        
        ALog log = new ALog();
        log.setAdminId(id);
        log.setUserName(userName);
        log.setHandleType(syslog.handleType().value());
        log.setTableName(syslog.tableName());
        log.setDescription(syslog.descript());
        log.setLoginIp(request.getRemoteAddr());
        log.setDateCreate(LocalDateTime.now());
        if(obj != null)
        {
        	if(obj instanceof SuperEntityWithIntegerID)
        	{
        		SuperEntityWithIntegerID superEntity = (SuperEntityWithIntegerID) obj;
        		log.setTableId(String.valueOf(superEntity.getId()));
        	}else if(obj instanceof SuperEntity)
        	{
        		SuperEntity superEntity = (SuperEntity) obj;
        		log.setTableId(String.valueOf(superEntity.getId()));
        	}else if (obj instanceof String)
        	{
        		log.setTableId((String) obj);
        	}else if(obj instanceof Integer || obj instanceof Long)
        	{
        		log.setTableId(String.valueOf(obj));
        	}
        }
        iALogService.save(log);
	}
	public static void main(String[] args) {
		System.out.println(LocalDateTime.now(ZoneId.systemDefault()));
		System.out.println(LocalDateTime.now());
	}
}

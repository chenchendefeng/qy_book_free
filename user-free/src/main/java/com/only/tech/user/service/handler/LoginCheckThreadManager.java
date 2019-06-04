package com.only.tech.user.service.handler;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.only.tech.base.QQUserInfoDto;
import com.only.tech.base.WxUserInfoDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.concurrent.*;

@Slf4j
@Service
public class LoginCheckThreadManager {
	
	 /**
     * 线程池的基本大小
     */
    static int corePoolSize = 10;
    /**
     * 线程池最大数量
     */
    static int maximumPoolSizeSize = 100;
    /**
     * 线程活动保持时间
     */
    static long keepAliveTime = 1;
    
    static BlockingQueue workQueue = new LinkedBlockingQueue<>(1000);
    
	private ExecutorService executor = new ThreadPoolExecutor(
            corePoolSize,
            maximumPoolSizeSize,
            keepAliveTime,
            TimeUnit.SECONDS,
            workQueue,
            new ThreadFactoryBuilder().setNameFormat("XX-task-%d").build());
	
	/**
	 * 校验短信验证码
	 * @param phone
	 * @param zone
	 * @param code
	 * @return
	 */
	public String checkMobCode(String phone, String zone, String code) {
		try {
			return executor.submit(new MobCheckTask(phone, zone, code)).get();
		} catch (InterruptedException | ExecutionException e) {
			log.error("LoginCheckThreadManager checkCode error",e);
		}
		return null;
	}


	/**
	 * 查询微信用户信息
	 * @param code
	 * @return
	 */
	public WxUserInfoDto queryWXUserInfoDto(String code){
		log.info(Thread.currentThread().getName() + ":queryQQUserInfoDto add queue code={}", code);
		try {
			return executor.submit(new QueryWXUserInfoTask(code)).get();
		} catch (InterruptedException | ExecutionException e) {
			log.error("LoginCheckThreadManager queryQQUserInfoDto error",e);
			return new WxUserInfoDto();
		}
	}


}

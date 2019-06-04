//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package ooh.chaos.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimeAspect {
    private static final Logger log = LoggerFactory.getLogger(ooh.chaos.aspect.TimeAspect.class);

    public TimeAspect() {
    }

    @Pointcut("execution(public * com.only.tech..*.*(..))")
    public void timeLog() {
    }

    @Around("timeLog()")
    public Object doBeforeAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] obj = joinPoint.getArgs();
        Signature signature = joinPoint.getSignature();
        String methodNmae = signature.getName();
        String className = signature.getDeclaringTypeName();
        long beginTime = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - beginTime;
        if (elapsedTime < 500L) {
            log.info(className + "." + methodNmae + ", elapsed: " + elapsedTime + "ms.");
        } else {
            log.warn(className + "." + methodNmae + ", elapsed: " + elapsedTime + "ms.");
        }

        return result;
    }
}

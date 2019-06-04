package com.only.tech.admin.common.targetMethod;

import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.ElementType;

@Documented  
@Inherited  
@Retention(RetentionPolicy.RUNTIME)  
@Target(ElementType.METHOD) 
public @interface RecordLog {
	/**
	 * 操作描述
	 * @return
	 */
	String descript() default "";
	/**
	 * 操作类型
	 * @return
	 */
	HandleType handleType();
	/**
	 * 操作表对象
	 * @return
	 */
	String tableName() default "";
}

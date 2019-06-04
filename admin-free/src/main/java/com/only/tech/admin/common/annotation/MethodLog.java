package com.only.tech.admin.common.annotation;

import java.lang.annotation.*;
 
/**
 * 记录数据库相关的操作如：新建，更新，删除。
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Documented
public @interface MethodLog {
    /**
     * 记录操作描述
     */
    String description() default "";
 
    /**
     * 增删改的数据的类型
     */
    Class<?> clazz();
}


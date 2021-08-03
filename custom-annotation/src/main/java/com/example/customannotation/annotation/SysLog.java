package com.example.customannotation.annotation;

import java.lang.annotation.*;

/**
 * 自定义注解
 * Target注解：指明了修饰的这个注解的 使用范围，即被描述的注解可以用在哪里。
 * Retention注解：指明修饰的注解的 生存周期，即会保留到哪个阶段。
 * Documented注解：指明修饰的注解，可以被例如javadoc此类的工具 文档化，只负责标记，没有成员取值
 * @author qzz
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SysLog {

    String value() default "";
    String desc() default "";
}

package com.zjl.mouse.utils.trace.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author zhujinglei
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface RpcTraceLog {
    String printDetail() default "yes";

    String printInputDetail() default "yes";

    String printOutputDetail() default "yes";
}

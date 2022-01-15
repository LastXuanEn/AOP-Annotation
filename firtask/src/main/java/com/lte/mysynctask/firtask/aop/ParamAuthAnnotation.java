package com.lte.mysynctask.firtask.aop;

import java.lang.annotation.*;

/**
 * @Auther: laite
 * @Date: 2022/1/15 - 01 - 15 - 21:51
 * @Description: com.lte.mysynctask.firtask.aop
 * @version: 1.0
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD,ElementType.ANNOTATION_TYPE})
public @interface ParamAuthAnnotation {
    String TYPE_INNER = "inner";

    String TYPE_OUT = "out";

    String value() default TYPE_INNER;
}

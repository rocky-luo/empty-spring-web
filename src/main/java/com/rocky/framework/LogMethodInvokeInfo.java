package com.rocky.framework;

import java.lang.annotation.*;

/**
 * Created by rocky on 17/3/21.
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LogMethodInvokeInfo {
    boolean reqInfo() default true;
    boolean retInfo() default true;
    boolean timing() default true;
    String logger() default "";
}

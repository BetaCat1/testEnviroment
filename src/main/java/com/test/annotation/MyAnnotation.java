package com.test.annotation;

import java.lang.annotation.*;

/**
 * @author ZWD
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyAnnotation {


}

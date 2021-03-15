package com.sda.spring.aop.aspect;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD) // used on method
@Retention(RetentionPolicy.RUNTIME) // used at runtime
public @interface Loggable {

}

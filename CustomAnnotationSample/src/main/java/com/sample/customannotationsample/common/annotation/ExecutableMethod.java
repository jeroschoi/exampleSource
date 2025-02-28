package com.sample.customannotationsample.common.annotation;

import org.springframework.context.annotation.Description;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Description("Service Method 관리 Custom Annotation")
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface ExecutableMethod {
    String methodName(); // 메소드명
}


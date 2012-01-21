package com.zenika.presentation.annotations.runtime.demo;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {

    String message() default "Hello World";

    int answer() default 42;

}

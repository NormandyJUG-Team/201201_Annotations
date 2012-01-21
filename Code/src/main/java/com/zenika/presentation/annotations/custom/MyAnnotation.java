package com.zenika.presentation.annotations.custom;

import java.lang.annotation.Documented;

@Documented
public @interface MyAnnotation {
    String message() default "Hello World";

    int answer() default 42;

    Season season() default Season.SUMMER;

    enum Season {
        SPRING, SUMMER, FALL, WINTER
    }

}

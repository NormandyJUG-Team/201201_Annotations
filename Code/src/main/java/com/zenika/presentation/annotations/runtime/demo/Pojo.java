package com.zenika.presentation.annotations.runtime.demo;

@MyAnnotation
public class Pojo {

    @MyAnnotation
    private String name = "Pojo";

    @MyAnnotation
    public void say(@MyAnnotation String message) {
        System.out.println("Foo !");
    }

}

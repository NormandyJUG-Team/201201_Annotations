package com.zenika.presentation.annotations.compilation;

@MessageHolder
public class Pojo2 {

    @MyAnnotation
    private int foo;

    private void bar() {
        System.out.println("Bar");
    }

}
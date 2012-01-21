package com.zenika.presentation.annotations.compilation;

@MyAnnotation
@MessageHolder
public class Pojo1 {

    private int foo;

    private void bar() {
        System.out.println("Bar");
    }

    @MyAnnotation
    private String getMessage() {
        return "Hello World";
    }

}

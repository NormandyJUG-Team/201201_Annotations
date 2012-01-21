package com.zenika.presentation.annotations.custom;

@MyAnnotation(season = MyAnnotation.Season.WINTER, message = "Ho, ho, ho !")
public class Pojo {

    @MyAnnotation
    private String message;

    @MyAnnotation
    public Pojo(String message) {
        this.message = message;
    }

    @MyAnnotation
    public void printMessage() {
        System.out.println(message);
    }

    @Override
    public String toString() {
        @MyAnnotation String msg = "Message : " + message;
        return msg;
    }

}

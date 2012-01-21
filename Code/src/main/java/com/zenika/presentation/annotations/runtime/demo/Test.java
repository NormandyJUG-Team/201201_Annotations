package com.zenika.presentation.annotations.runtime.demo;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Test {

    @org.junit.Test
    public void testAnnotationDetection() {

        //Annotations sur le package
        Package pkg = Pojo.class.getPackage();
        Annotation[] pkgAnnotations = pkg.getDeclaredAnnotations();
        printAnnotations("Package " + pkg.getName(), pkgAnnotations);

        // Annotations sur la classe
        Annotation[] classAnnotations = Pojo.class.getDeclaredAnnotations();
        printAnnotations("Classe " + Pojo.class.getName(), classAnnotations);

        // Annotations sur les champs
        Field[] fields = Pojo.class.getDeclaredFields();
        for (Field field : fields) {
            Annotation[] fieldAnnotations = field.getDeclaredAnnotations();
            printAnnotations("Champ " + field.getName(), fieldAnnotations);
        }

        // Annotations sur les méthodes
        Method[] methods = Pojo.class.getDeclaredMethods();
        for (Method method : methods) {

            Annotation[] methodAnnotations = method.getAnnotations();
            printAnnotations("\nMéthode " + method.getName(), methodAnnotations);

            // Annotations sur les paramètres de méthodes
            Annotation[][] paramsAnnotations = method.getParameterAnnotations();
            printParameterAnnotations("\tParamètres", paramsAnnotations);
        }

    }

    private static void printAnnotations(String header, Annotation... annotations) {
        System.out.println("\n" + header);
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }
    }

    private static void printParameterAnnotations(String header, Annotation[]... annotations) {
        System.out.println("\n" + header);
        for (Annotation[] annotation : annotations) {
            System.out.println(Arrays.toString(annotation));
        }
    }

}

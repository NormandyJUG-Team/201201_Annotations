package com.zenika.presentation.annotations.injection.demo;

import com.zenika.presentation.annotations.injection.InheritedAnnotationsInjector;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class InjectorDemo {

    @Test
    public void testInjector() {

        InheritedAnnotationsInjector injector = new InheritedAnnotationsInjector(Pojo.class);

        assertFalse(Pojo.class.isAnnotationPresent(MyAnnotation.class));

        injector.injectInterfaceInheritedAnnotations();
        assertTrue(Pojo.class.isAnnotationPresent(MyAnnotation.class));

        injector.injectPackageInheritedAnnotations();
        assertTrue(Pojo.class.isAnnotationPresent(MyAnnotation.class));
    }

}

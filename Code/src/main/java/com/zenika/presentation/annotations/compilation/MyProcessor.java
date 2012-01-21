package com.zenika.presentation.annotations.compilation;

import javax.annotation.processing.*;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;
import java.util.Set;

@SupportedAnnotationTypes("com.zenika.presentation.annotations.compilation.MyAnnotation")
public class MyProcessor extends AbstractProcessor {

    private Types types;
    private Elements elements;
    private Messager messager;
    private Filer filer;

    @Override
    public void init(ProcessingEnvironment processingEnv) {
        super.init(processingEnv);
        types = processingEnv.getTypeUtils();
        elements = processingEnv.getElementUtils();
        messager = processingEnv.getMessager();
        filer = processingEnv.getFiler();
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {

        //TODO

        return false;
    }
}

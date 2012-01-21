package com.zenika.presentation.annotations.compilation;

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;
import javax.tools.Diagnostic;
import java.util.Set;

@SupportedAnnotationTypes("com.zenika.presentation.annotations.compilation.*")
@SupportedSourceVersion(SourceVersion.RELEASE_6)
public class ListingProcessor extends AbstractProcessor {

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

        for (TypeElement annotation : annotations) {
            for (Element e : roundEnv.getElementsAnnotatedWith(annotation)) {
                messager.printMessage(Diagnostic.Kind.NOTE, e.getSimpleName());
            }
        }

        return false;
    }
}
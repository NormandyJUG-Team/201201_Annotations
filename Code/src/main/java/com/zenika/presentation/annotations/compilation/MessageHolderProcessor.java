package com.zenika.presentation.annotations.compilation;

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.ElementFilter;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;
import javax.tools.Diagnostic;
import java.util.List;
import java.util.Set;

@SupportedAnnotationTypes("com.zenika.presentation.annotations.compilation.MessageHolder")
@SupportedSourceVersion(SourceVersion.RELEASE_6)
public class MessageHolderProcessor extends AbstractProcessor {

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

                boolean hasGetMessageMethod = false;
                List<ExecutableElement> methodElements = ElementFilter.methodsIn(e.getEnclosedElements());
                for (ExecutableElement methodElement : methodElements) {
                    if (methodElement.getSimpleName().contentEquals("getMessage")) {
                        hasGetMessageMethod = true;
                        break;
                    }
                }

                if (!hasGetMessageMethod) {
                    messager.printMessage(Diagnostic.Kind.ERROR,
                            "Classes annotated with MessageHolder must implement a getMessage() method.");
                }
            }
        }

        return false;
    }

}
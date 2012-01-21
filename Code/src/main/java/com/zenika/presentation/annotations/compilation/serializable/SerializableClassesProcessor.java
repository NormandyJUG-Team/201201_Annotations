package com.zenika.presentation.annotations.compilation.serializable;

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.TypeElement;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;
import javax.tools.Diagnostic;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@SupportedSourceVersion(SourceVersion.RELEASE_6)
@SupportedAnnotationTypes("com.zenika.presentation.annotations.compilation.serializable.SerializableClasses")
public class SerializableClassesProcessor extends AbstractProcessor {

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

        // The Serializable interface - used for comparison
        // We can do this because Serializable is a core Java class, therefore always loaded
        TypeMirror serializable = elements.getTypeElement(Serializable.class.getCanonicalName()).asType();

        // Find the annotated packages
        for (TypeElement annotation : annotations) {
            for (Element pkg : roundEnv.getElementsAnnotatedWith(annotation)) {

                // List the elements inside the package
                List<? extends Element> pkgElements = pkg.getEnclosedElements();
                for (Element pkgElement : pkgElements) {

                    // Keep classes only (not enums or interfaces)
                    if (pkgElement.getKind() != ElementKind.CLASS) {
                        continue;
                    }

                    // Test if the class is Serializable
                    boolean isSerializable = types.isAssignable(pkgElement.asType(), serializable);
                    if (!isSerializable) {
                        messager.printMessage(Diagnostic.Kind.ERROR,
                                "The following class is not Serializable : " + pkg.getSimpleName() + "." + pkgElement.getSimpleName());
                    }

                }

            }
        }

        // Prevent other processors from processing this annotation
        return true;
    }

}
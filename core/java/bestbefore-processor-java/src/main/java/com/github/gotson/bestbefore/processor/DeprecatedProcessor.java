package com.github.gotson.bestbefore.processor;

import com.google.auto.service.AutoService;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;
import java.util.Set;

@SupportedAnnotationTypes(
    "java.lang.Deprecated"
)
@SupportedSourceVersion(SourceVersion.RELEASE_11)
@AutoService(Processor.class)
public class DeprecatedProcessor extends AbstractProcessor {
    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        for (TypeElement annotation : annotations) {
            for (Element element : roundEnv.getElementsAnnotatedWith(annotation)) {

                processingEnv.getMessager().printMessage(Diagnostic.Kind.ERROR, "Deprecated code should be removed", element);
            }
        }

        return true;
    }
}

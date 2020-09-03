package test.annotations;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.bytecode.AnnotationsAttribute;
import javassist.bytecode.ClassFile;
import javassist.bytecode.ConstPool;
import javassist.bytecode.annotation.Annotation;
import javassist.bytecode.annotation.StringMemberValue;

import java.lang.reflect.Method;

public final class AnnotationRuntimeHelper {


    /**
     *
     * @param clazz
     * @param relatedMethod - metodo a cui è associata l'annotazione
     * @param annotationToModifyName - name dell' annotazione da modificare
     * @param propertyName
     * @param propertyValue
     */
    public static void changeAnnotationValue(Class clazz, Method relatedMethod,
                                                                    String annotationToModifyName, String propertyName,
                                                                    String propertyValue){
        try {
            ClassPool pool = ClassPool.getDefault();
            //extracting the class
            CtClass cc = pool.getCtClass(clazz.getName());
            //looking for the method to apply the annotation on
            CtMethod methodDescriptor = cc.getDeclaredMethod(relatedMethod.getName());
            // create the annotation
            ClassFile ccFile = cc.getClassFile();
            ConstPool constpool = ccFile.getConstPool();

            AnnotationsAttribute attr = new AnnotationsAttribute(constpool, AnnotationsAttribute.visibleTag);
            Annotation newAnnot = new Annotation(annotationToModifyName, constpool);

            newAnnot.addMemberValue(propertyName, new StringMemberValue(propertyValue,ccFile.getConstPool()));
            attr.addAnnotation(newAnnot);
            // add the annotation to the method descriptor
            methodDescriptor.getMethodInfo().addAttribute(attr);

        }catch (Exception e){
            System.out.println(e);
        }


    }

}

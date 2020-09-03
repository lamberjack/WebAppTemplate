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


public class MainAnnotationChange <T extends java.lang.annotation.Annotation> {


    public static void main(String[] args) {

        try {
            ClassWithAnnotation classInstance = new ClassWithAnnotation();

            methodAnnotationValueModfier(classInstance, "getUsername", "test.annotations.CustomAnnotation", "key", "nuovo_valore_chiave");

            Method methodWithAnnotation = classInstance.getClass().getDeclaredMethod("getUsername");
            for (Object annotation : methodWithAnnotation.getAnnotations()) {
                System.out.println("annotazione  CORRENTE modificata: " + annotation);
            }
        }catch (Exception e){
            e.printStackTrace();
        }


    }




    private static void methodAnnotationValueModfier(Object classInstance, String methodName,
                                                     String annotationName,
                                                     String annotationPropertyName, String annotationPropertyValue) {
        try {
            // recupero la classe relativa all'oggetto passato
            ClassPool pool = ClassPool.getDefault();
            CtClass relatedClass = pool.getCtClass(classInstance.getClass().getName());

            // scorre i metodi della classe per trovare quelli con l'annotazione relativa
            CtMethod[] methods = relatedClass.getMethods();
            for (CtMethod m : methods) {
                // si suppone che il metodo dal nome passato abbia l'annotazione dal nome passato
                if ( m.getName().equals(methodName)) {


                    // creazione dell'annotazione con il valore di un attributo modificato
                    ClassFile ccFile = relatedClass.getClassFile();
                    ConstPool constpool = ccFile.getConstPool();
                    AnnotationsAttribute attr = new AnnotationsAttribute(constpool, AnnotationsAttribute.visibleTag);
                    Annotation annot = new Annotation(annotationName, constpool);
                    annot.addMemberValue(annotationPropertyName, new StringMemberValue(annotationPropertyValue,ccFile.getConstPool()));
                    attr.addAnnotation(annot);

                    // aggiunge l'annotazione al metodo
                    m.getMethodInfo().addAttribute(attr);


                    m.getAnnotations();
                    for (Object annotation : m.getAnnotations()) {
                        System.out.println("annotazione modificata: "+annotation);
                    }


                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
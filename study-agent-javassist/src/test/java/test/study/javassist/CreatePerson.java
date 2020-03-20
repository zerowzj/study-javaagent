package test.study.javassist;

import javassist.*;

public class CreatePerson {

    public static void main(String[] args) throws Exception{
        ClassPool pool = ClassPool.getDefault();

        CtClass ctClass= pool.makeClass("com.test.Person");

        CtField ctField = new CtField(pool.get("java.lang.String"), "name", ctClass);
        ctField.setModifiers(Modifier.PRIVATE);
        ctClass.addField(ctField);

        ctClass.addMethod(CtNewMethod.setter("setName",ctField));
        ctClass.addMethod(CtNewMethod.setter("getName",ctField));

        ctClass.writeFile("d:/");

    }
}

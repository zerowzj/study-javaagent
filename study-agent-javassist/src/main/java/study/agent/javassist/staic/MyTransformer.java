package study.agent.javassist.staic;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;

public class MyTransformer implements ClassFileTransformer {

    public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined,
                            ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {
//        System.out.println(className);
        //java自带的方法不进行处理
        if (className.startsWith("java") || className.startsWith("sun")) {
            return classfileBuffer;
        }

        /**
         * 好像使用premain这个className是没问题的，但使用attach时className的.变成了/，所以如果是attach，那么这里需要替换
         */
        className = className.replace('/', '.');

        // 只处理MyApplication类
        if (!className.startsWith("study.agent")) {
            return classfileBuffer;
        }

        try {
            ClassPool classPool = ClassPool.getDefault();
            CtClass ctClass = classPool.get(className);
            CtMethod[] declaredMethods = ctClass.getDeclaredMethods();
            for (CtMethod declaredMethod : declaredMethods) {
                // 只处理testPrint方法
//                if (Objects.equals("testPrint", declaredMethod.getName())) {
                    /**
                     * 在方法执行之前加入打印语句
                     */
                    declaredMethod.insertBefore("System.out.println(\"欧，亲爱的，\");");
                    /**
                     * 在方法执行之后加入打印语句
                     */
                    declaredMethod.insertAfter("System.out.println(\"祝你一切安好！\");");
//                }
            }
            return ctClass.toBytecode();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return classfileBuffer;
    }
}

package study.agent.javassist.monitor;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtBehavior;
import javassist.CtClass;
import javassist.expr.ExprEditor;
import javassist.expr.MethodCall;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;

public class MonitorTransformer implements ClassFileTransformer {

    @Override
    public byte[] transform(ClassLoader loader,
                            String className,
                            Class<?> classBeingRedefined,
                            ProtectionDomain protectionDomain,
                            byte[] classfileBuffer) throws IllegalClassFormatException {
        byte[] byteCode = null;
        try {
            if(className == null){
//                System.out.println("className is null");
                return classfileBuffer;
            }
            String currentClassName = className.replaceAll("/", ".");
            if (!currentClassName.startsWith("study.agent") && !currentClassName.startsWith("test.study.agent")) {
                return classfileBuffer;
            }

            System.out.println("transform: [" + currentClassName + "]");
            ClassPool pool = ClassPool.getDefault();
            if(pool ==null){
                return classfileBuffer;
            }
            CtClass ctClass = pool.get(currentClassName);
            if(ctClass == null){
                return classfileBuffer;
            }
            CtBehavior[] methods = ctClass.getDeclaredBehaviors();
            for (CtBehavior method : methods) {
                enhanceMethod(method);
            }
            byteCode = ctClass.toBytecode();
        } catch (Exception ex) {
            ex.printStackTrace();

        }
        return byteCode;
    }

    private void enhanceMethod(CtBehavior method) throws Exception {
        if (method.isEmpty()) {
            return;
        }
        String methodName = method.getName();
        if (methodName.equalsIgnoreCase("main")) { // 不提升main方法
            return;
        }
        StringBuilder source = new StringBuilder();
        source.append("{")
                .append("long start = System.nanoTime();\n") //前置增强: 打入时间戳
                .append("$_ = $proceed($$);\n") //保留原有的代码处理逻辑
                .append("System.out.print(\"method:[" + methodName + "]\");").append("\n")
                .append("System.out.println(\" cost:[\" +(System.nanoTime() -start)+ \"ns]\");") //后置增强
                .append("}");

        ExprEditor editor = new ExprEditor() {
            @Override
            public void edit(MethodCall methodCall) throws CannotCompileException {
                methodCall.replace(source.toString());
            }
        };
        method.instrument(editor);
    }
}

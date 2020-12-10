package study.agent.javassist.dynamic;

import java.lang.instrument.Instrumentation;

public class DynamicAgent {


    public static void agentmain(String agentArgs, Instrumentation inst) {

        Class<?>[] clazzes = inst.getAllLoadedClasses();
        for (Class<?> clazz : clazzes) {
            System.out.println(clazz.getName());
        }
        System.out.println("agent run completely");
    }
}

package study.agent.javassist.monitor;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.Instrumentation;

public class MonitorAgent {

    public static void premain(String agentArgs, Instrumentation inst) {
        System.out.println("this is an perform monitor agent.");
        // 添加 Transformer
        ClassFileTransformer transformer = new MonitorTransformer();
        inst.addTransformer(transformer);
    }
}

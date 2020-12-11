package study.jdk.javaagent.test;

import lombok.extern.slf4j.Slf4j;

import java.lang.instrument.Instrumentation;

@Slf4j
public class PremainAgent {

    public static void premain(String agentArgs, Instrumentation inst) {
        log.info("");
        inst.addTransformer(new CustomClassFileTransformer());
    }

    public static void premain(String agentArgs) {
        log.info("");
    }
}

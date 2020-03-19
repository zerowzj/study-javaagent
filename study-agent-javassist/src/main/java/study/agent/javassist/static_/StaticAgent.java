package study.agent.javassist.static_;

import java.lang.instrument.Instrumentation;

public class StaticAgent {

    /**
     * 注意，这个premain方法签名是Java Agent约定的，不要随意修改
     *
     * @param agentArgs
     * @param instrumentation
     */
    public static void premain(String agentArgs, Instrumentation instrumentation) {
        instrumentation.addTransformer(new StaticTransformer());
    }
}

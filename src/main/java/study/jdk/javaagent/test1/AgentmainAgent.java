package study.jdk.javaagent.test1;

import lombok.extern.slf4j.Slf4j;

import java.lang.instrument.Instrumentation;

@Slf4j
public class AgentmainAgent {

    public static void premain(String agentArgs, Instrumentation inst) {
        log.info("");
    }
}

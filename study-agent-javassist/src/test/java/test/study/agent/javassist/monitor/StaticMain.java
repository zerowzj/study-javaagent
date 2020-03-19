package test.study.agent.javassist.monitor;

import java.util.concurrent.TimeUnit;

public class StaticMain {

    public static void main(String[] args) {
        while (true) {
            testPrint();
        }
    }

    private static void testPrint() {
        System.out.println("这是我第 " + (System.currentTimeMillis() / 1000) + " 次想你");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
        }
    }
}

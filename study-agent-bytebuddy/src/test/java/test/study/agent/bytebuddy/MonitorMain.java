package test.study.agent.bytebuddy;

public class MonitorMain {

    private void fun1() throws Exception {
        System.out.println("this is fun 1.");
        Thread.sleep(500);
    }

    private void fun2() throws Exception {
        System.out.println("this is fun 2.");
        Thread.sleep(500);
    }

    public static void main(String[] args) throws Exception {
        MonitorMain test = new MonitorMain();
        test.fun1();
        test.fun2();
    }
}

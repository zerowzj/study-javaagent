package test.study.agent;

public class MonitorMain {
    private void fun1() {
        System.out.println("this is fun 1.");
    }

    private void fun2() {
        System.out.println("this is fun 2.");
    }

    public static void main(String[] args) {
        MonitorMain test = new MonitorMain();
        test.fun1();
        test.fun2();
    }
}

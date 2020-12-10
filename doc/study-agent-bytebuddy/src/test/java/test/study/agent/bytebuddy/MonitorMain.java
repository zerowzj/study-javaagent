package test.study.agent.bytebuddy;

import java.util.ArrayList;
import java.util.List;

public class MonitorMain {

    public static void main(String[] args) throws Exception {
        boolean is = true;
        while (is) {
            List<Object> list = new ArrayList<Object>();
            list.add("hello world");
        }
    }
}

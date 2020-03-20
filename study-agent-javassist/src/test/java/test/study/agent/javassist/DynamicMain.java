package test.study.agent.javassist;

import com.sun.tools.attach.VirtualMachine;
import com.sun.tools.attach.VirtualMachineDescriptor;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class DynamicMain {

    public static void main(String[] args) {

        try {
            while (true){
                System.out.println("sfdsfads");
                TimeUnit.SECONDS.sleep(3);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

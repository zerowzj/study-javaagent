package study.agent.javassist.dynamic;

import com.sun.tools.attach.VirtualMachine;
import com.sun.tools.attach.VirtualMachineDescriptor;

import java.util.List;

public class DynamicMainx {

    private static final String AGENT = "D:\\idea\\study\\study-jdk-agent\\study-agent-javassist\\target\\study-agent.jar";

    public static void main(String[] args) {

        try {
            List<VirtualMachineDescriptor> vmdLt = VirtualMachine.list();
            for (VirtualMachineDescriptor vmd : vmdLt) {
                if (vmd.displayName().endsWith("DynamicMain")) {
                    System.out.println("id="+ vmd.id());
                    VirtualMachine vm = VirtualMachine.attach(vmd.id());
                    vm.loadAgent(AGENT, "cxs");
                    System.out.println("ok");
                    vm.detach();
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

package study.bytecode.cglib.proxy;

import lombok.extern.slf4j.Slf4j;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

@Slf4j
public class HelloMethodInterceptor implements MethodInterceptor {

    public Object intercept(Object proxy, Method method, Object[] args,
                            MethodProxy methodProxy) throws Throwable {
        log.info("advice before");
        log.info("{}", method.getName());

        Object result = null;
        try {
            result = methodProxy.invokeSuper(proxy, args);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        log.info("advice after");
        return result;
    }
}

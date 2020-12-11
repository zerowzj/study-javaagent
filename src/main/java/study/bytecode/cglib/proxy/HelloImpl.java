package study.bytecode.cglib.proxy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HelloImpl {

    public void sayHi(){
        log.info("hi...");
    }
}

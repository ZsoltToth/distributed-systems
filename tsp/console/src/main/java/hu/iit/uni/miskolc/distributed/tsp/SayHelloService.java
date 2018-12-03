package hu.iit.uni.miskolc.distributed.tsp;

import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.Payload;

public interface SayHelloService {

    @Gateway(requestChannel = "helloChannel")
    void say(@Payload String text);
}

package hu.iit.uni.miskolc.distributed.tsp;

import org.springframework.integration.annotation.Gateway;

public interface SayHelloService {

    @Gateway(requestChannel = "helloChannel")
    String getIndex();
}

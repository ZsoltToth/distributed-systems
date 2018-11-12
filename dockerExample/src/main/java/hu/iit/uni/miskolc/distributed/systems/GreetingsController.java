package hu.iit.uni.miskolc.distributed.systems;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingsController {

    @RequestMapping("/hello")
    public String sayHello(@RequestParam("name") String name){
        return String.format("Hello %s",name).toUpperCase();
    }
}

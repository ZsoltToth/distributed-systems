package hu.uni.miskolc.iit.distributed.console2http.console;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import hu.uni.miskolc.iit.distributed.console2http.console.gateway.TemperatureConverterGateway;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;


import static org.springframework.messaging.support.MessageBuilder.withPayload;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        ApplicationContext context = new ClassPathXmlApplicationContext("/si-config.xml");
                //new FileSystemXmlApplicationContext("console2http.console/src/main/resources/si-config.xml");

        MessageChannel channel = context.getBean("tempConverterChannel", MessageChannel.class);

        for(int i = 0; i < 33; i++) {
            Message<Double> msg = MessageBuilder.withPayload(Double.valueOf(i)).build();
            channel.send(msg);
        }

//        TemperatureConverterGateway gateway = context.getBean("temperatureConverterGateway",TemperatureConverterGateway.class);
//        System.out.println("Gateway -> "+ gateway.fahrenheit2celsius(0));

    }
}

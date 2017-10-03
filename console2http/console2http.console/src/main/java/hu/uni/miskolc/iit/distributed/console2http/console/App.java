package hu.uni.miskolc.iit.distributed.console2http.console;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import hu.uni.miskolc.iit.distributed.console2http.console.gateway.TemperatureConverterGateway;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static org.springframework.messaging.support.MessageBuilder.withPayload;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException {
        System.out.println( "Hello World!" );
        ApplicationContext context = new ClassPathXmlApplicationContext("/si-config.xml");
                //new FileSystemXmlApplicationContext("console2http.console/src/main/resources/si-config.xml");
//      testF2CChannel(context);
        testGateway(context);

        TemperatureConverterGateway gateway = context.getBean("temperatureConverterGateway", TemperatureConverterGateway.class);
        String line = null;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while((line = br.readLine())!= null){
            if(line.startsWith("exit")){
                System.out.println("bye bye");
                break;
            }
            String[] parts = line.split("\\s");
            if(parts.length != 2){
                continue;
            }
            if(!parts[0].matches("\\d+")||!parts[1].matches("[fFcC]")){
                System.out.println("Wrong format!");
                continue;
            }
            double value = Double.parseDouble(parts[0]);
            if (parts[1].matches("[cC]")){
                System.out.println(line +" ->" + gateway.celsius2fahrenheit(value) + "F");
            }
            if(parts[1].matches("[fF]")){
                System.out.println(line +" ->" + gateway.fahrenheit2celsius(value) + "C");
            }
        }
    }

    private static void testGateway(ApplicationContext context){
        System.out.println("Gateway Test");
        TemperatureConverterGateway gateway = context.getBean("temperatureConverterGateway",TemperatureConverterGateway.class);
        for(int i = 0; i< 33; i++) {
            double celsius = Double.parseDouble(gateway.fahrenheit2celsius(i));
            System.out.println(String.format("%f F -> %f C",(double)i,celsius));
        }
    }

    private static void testF2CChannel(ApplicationContext context){
        System.out.println("Test a channel");
        MessageChannel channel = context.getBean("F2CReqChannel", MessageChannel.class);

        for(int i = 0; i < 33; i++) {
            Message<Double> msg = MessageBuilder.withPayload(Double.valueOf(i)).build();
            channel.send(msg);
        }
    }
}

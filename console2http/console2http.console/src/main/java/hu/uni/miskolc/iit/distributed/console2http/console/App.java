package hu.uni.miskolc.iit.distributed.console2http.console;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import hu.uni.miskolc.iit.distributed.console2http.console.gateway.TemperatureConverterGateway;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        ApplicationContext context = new FileSystemXmlApplicationContext("src/main/resources/si-config.xml");
        TemperatureConverterGateway gateway = context.getBean("temperatureConverterGateway",TemperatureConverterGateway.class);
        System.out.println(gateway.celsius2fahrenheit(0));
    }
}

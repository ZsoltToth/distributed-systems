package hu.uni.miskolc.iit.distributed.systems;

import hu.uni.miskolc.iit.distributed.egov.ps.model.Person;
import hu.uni.miskolc.iit.distributed.systems.gateway.PersonSearchGateway;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("/si-config.xml");
        MessageChannel stoutChannel = (MessageChannel) context.getBean("chatChannel", MessageChannel.class);
//        MessageChannel peopleRequestChannel = (MessageChannel) context.getBean("peopleRequestChannel",MessageChannel.class);

//        peopleRequestChannel.send(MessageBuilder.withPayload("").build());

        Message<String> msg = MessageBuilder.withPayload("Hello World from Channel").build();

        stoutChannel.send(msg);

        PersonSearchGateway gateway = (PersonSearchGateway) context.getBean("PersonSearchGateway",PersonSearchGateway.class);

        for(Person person : gateway.listAllPeople()){
            System.out.println(person.getFirstName()+" "+person.getLastName());
        }
//        System.out.println(gateway.listAllPeople());

    }
}

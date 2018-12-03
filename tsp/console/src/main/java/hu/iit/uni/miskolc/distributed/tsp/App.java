package hu.iit.uni.miskolc.distributed.tsp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.ClientHttpRequest;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.integration.http.outbound.HttpRequestExecutingMessageHandler;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.messaging.support.MessageBuilder;

import java.io.IOException;
import java.net.URI;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException {
        ApplicationContext context = new AnnotationConfigApplicationContext(ConsoleApplicationContext.class);
        System.out.println( context.getBean("hello") );
        MessageChannel channel = (MessageChannel) context.getBean("helloChannel");
        Message<String> msg = MessageBuilder.withPayload("hello spring integration").build();
        channel.send(msg);
//        channel = (MessageChannel) context.getBean("filteredChannel");
//        msg = MessageBuilder.withPayload("hello spring integration with header").setHeader("integration", "true").build();
//        channel.send(msg);

//        ClientHttpRequestFactory httpRequestFactory = new SimpleClientHttpRequestFactory();
//        ClientHttpRequest request = httpRequestFactory.createRequest(URI.create("http://index.hu"), HttpMethod.GET);
//        ClientHttpResponse response = request.execute();
//        System.out.println(response.getStatusCode());

        HttpRequestExecutingMessageHandler httpHandler = (HttpRequestExecutingMessageHandler) context.getBean("getIndex");
        httpHandler.handleMessage(MessageBuilder.withPayload("hello").build());

    }
}

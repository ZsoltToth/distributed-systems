package hu.iit.uni.miskolc.distributed.tsp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.integration.annotation.*;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.channel.PublishSubscribeChannel;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.core.MessageSelector;
import org.springframework.integration.filter.MessageFilter;
import org.springframework.integration.http.outbound.HttpRequestExecutingMessageHandler;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.MessagingException;
import org.springframework.messaging.support.ChannelInterceptor;
import org.springframework.stereotype.Service;

import java.net.URI;

@Configuration
@EnableIntegration
@IntegrationComponentScan("hu.iit.uni.miskolc.distributed.tsp")
public class ConsoleApplicationContext {

    @Bean
    public String hello(){
        return "Hello World";
    }

    @Bean
    public MessageChannel helloChannel(){
        PublishSubscribeChannel channel = new PublishSubscribeChannel();

        return channel;
    }

//    @Bean
//    public MessageChannel filteredChannel(){
//        MessageChannel channel = new DirectChannel();
//        return channel;
//    }

    @Bean
    @ServiceActivator(inputChannel = "helloChannel")
    public MessageHandler soutHandler(){
        return new MessageHandler() {
            @Override
            public void handleMessage(Message<?> message) throws MessagingException {
                System.out.println(message.getPayload().toString().toUpperCase());
            }
        };
    }

    @Bean
    @ServiceActivator(inputChannel = "helloChannel")
    public MessageHandler echoHandler(){
        return new MessageHandler() {
            @Override
            public void handleMessage(Message<?> message) throws MessagingException {
                System.out.println(message.getPayload().toString());
            }
        };
    }

    @Bean
    public HttpRequestExecutingMessageHandler getIndex(){
        HttpRequestExecutingMessageHandler result = new HttpRequestExecutingMessageHandler(URI.create("http://index.hu"));
        return  result;
    }

//    @Bean
//    @Filter(inputChannel = "filteredChannel", outputChannel = "helloChannel")
//    public MessageFilter filter(){
//        MessageFilter filter = new MessageFilter(new MessageSelector() {
//            @Override
//            public boolean accept(Message<?> message) {
//                return message.getHeaders().containsKey("integration");
//            }
//        });
//        filter.setRequiresReply(false);
//        return filter;
//
//    }
}

package hu.uni.miskolc.iit.distributed.console2file;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;

/**
 * Writes each console line into a file in the outbound directory.
 * 
 * This example is based on the Spring Integration Tutorial of Intertech.
 * 
 * https://www.intertech.com/Blog/spring-integration-enterprise-integration-veg-o-matic/
 * 
 * @author Zsolt Toth
 * 
 *
 */
public class App {
	public static void main(String[] args) throws IOException {
		System.out.println("Hello World!");
		Logger logger = LogManager.getRootLogger();
		logger.warn("Hello World!");
		ApplicationContext context = new FileSystemXmlApplicationContext("src/main/resources/si-config.xml");

		MessageChannel channel = context.getBean("messageChannel", MessageChannel.class);
		
		String line = "";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while ((line = br.readLine()) != null) {
			if (line == null || "".equals(line)) {
				continue;
			}
			if (line.startsWith("exit")) {
				break;
			}

			Message<String> meassage = MessageBuilder.withPayload(line).build();
			logger.info(String.format("Sending msg: %s", line));
			channel.send(meassage);
		}		
		System.out.println("bye bye");

	}
}

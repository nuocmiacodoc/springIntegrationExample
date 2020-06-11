package com.java.spring.integration.example.endpoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.PollableChannel;
import org.springframework.stereotype.Component;

@Component
public class InboundEnpoint
{
	private Logger log = LoggerFactory.getLogger(this.getClass().getName());

	@Autowired
	@Qualifier("reply.channel")
	PollableChannel receivedChannel;

	@Autowired @Qualifier("post.request.channel")
	MessageChannel postRequestChannel;

	public void postReceivedChanelMessage(String chanelMessage) {
		System.out.println("--- receive message ---");
		System.out.println(chanelMessage);

		//post received message
		Message<?> message = MessageBuilder.withPayload(chanelMessage).build();
		postRequestChannel.send(message);
		Message<?> receivedMsg2 = receivedChannel.receive();
		String serverMsg2 =  receivedMsg2.getPayload().toString();
		System.out.println("--- post received message ---");
		System.out.println("result: " + serverMsg2);
	}
}

package com.perform.svs.stomp_test.config;

import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.ChannelInterceptorAdapter;

public class StompInterceptor extends ChannelInterceptorAdapter{

	@Override
	public Message<?> postReceive(Message<?> message, MessageChannel channel) {
		System.out.println("postReceive");
		return super.postReceive(message, channel);
	}

	@Override
	public void postSend(Message<?> message, MessageChannel channel, boolean sent) {
		System.out.println("postSend");
		super.postSend(message, channel, sent);
	}

	@Override
	public boolean preReceive(MessageChannel channel) {
		System.out.println("preReceive");
		return super.preReceive(channel);
	}

	@Override
	public Message<?> preSend(Message<?> message, MessageChannel channel) {
		System.out.println("preSend");

//		 StompHeaderAccessor headerAccessor= StompHeaderAccessor.wrap(message);
		 
		return super.preSend(message, channel);
	}
	
}

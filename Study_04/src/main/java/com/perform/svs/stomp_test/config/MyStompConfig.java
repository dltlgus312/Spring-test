package com.perform.svs.stomp_test.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.ChannelRegistration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

/**
 * RELEASE 4.0.1 AbstractWebSocketMessageBrokerConfigurer 상속가능
 */
@Configuration
@EnableWebSocketMessageBroker
public class MyStompConfig extends AbstractWebSocketMessageBrokerConfigurer{
	
	/**
	 * Intercepter 
	 * preSend, postSend 오버라이드 하여 작성
	 */
	StompInterceptor interceptors = new StompInterceptor();
	
	/**
	 * Stomp 최초 연결 접속 설정
	 */
	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		
		/* 스프링 시큐리티에 의한 크로스 도메인 오류 해결 */
		/* RELEASE 4.1.2 setAllowedOrigins  */
		/* 참고 URI : https://m.blog.naver.com/PostView.nhn?blogId=moonv11&logNo=220658500567&proxyReferer=https%3A%2F%2Fwww.google.com%2F */
		/* registry.addEndpoint("/StompMessageTester").setAllowedOrigins("*").withSockJS(); */
		
		registry.addEndpoint("/StompMessageTester").withSockJS();
	}

	/**
	 * Stomp 기본 설정
	 */
	@Override
	public void configureMessageBroker(MessageBrokerRegistry registry) {
		
		/* 서버 > 클라 ( 원하는 대로 추가 ) */
		registry.enableSimpleBroker("/topic", "/chating", "/tester");
		
		/* 클라 > 서버 ( 원하는 대로 추가 ) */
		registry.setApplicationDestinationPrefixes("/appication", "/tester", "/chating");

	}

	
	/**
	 * 인터셉터 설정
	 */
	@Override
	public void configureClientInboundChannel(ChannelRegistration registration) {
		registration.setInterceptors(interceptors);
	}

}

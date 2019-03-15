package com.perform.svs.websocket_test.handler;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class Handler extends TextWebSocketHandler{
	
	/**
	 * 세션을 통해 메시지 전송
	 */
	private List<WebSocketSession> sessions;
	
	/**
	 * 연결 시
	 */
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		if(sessions == null) sessions = new ArrayList<>();
		sessions.add(session);
	}
	
	/**
	 * 연결 종료 시
	 */
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		sessions.remove(session);
	}
	
	/**
	 * 메시지 전송 시 ( 클라 > 서버 받을 때 호출)
	 */
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		for(WebSocketSession s : sessions) s.sendMessage(message);
	}
		
}
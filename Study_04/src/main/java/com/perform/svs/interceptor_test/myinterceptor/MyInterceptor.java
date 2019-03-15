package com.perform.svs.interceptor_test.myinterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


public class MyInterceptor extends HandlerInterceptorAdapter{

	/**
	 * 메소드 실행 전
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		System.out.println("컨트롤러 호출 전");
		System.out.println("Interceptor Pre Handler를 실행 합니다.");
		
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		
		if(id == null || "".equals(id)){
			session.setAttribute("id", "LEESIHYEON");
			session.setMaxInactiveInterval(10);
		}
		
		return true;
	}

	/**
	 * 메소드 실행 후
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		System.out.println("컨트롤러 호출 후");
		System.out.println("Interceptor Post Handler를 실행합니다.");
		
		HttpSession session = request.getSession();
		String pw = (String) session.getAttribute("pw");
		
		if(pw == null || "".equals(pw)){
			session.setAttribute("pw", "1008");
		}
	}

	/**
	 * view 페이지 전송 완료 후
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
		System.out.println("VIEW 전송 완료 후");
		System.out.println("Interceptor After Completion Handler를 실행합니다.");
		
		HttpSession session = request.getSession();
		String age = (String) session.getAttribute("age");
		
		if(age == null || "".equals(age)){
			
			/* 로직 문제로 jsp 페이지단에서는 확인할 수 없다. */
			session.setAttribute("age", "27");
		}
		
		
	}
	
	
}

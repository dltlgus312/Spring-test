package com.perform.svs.aop_session_test.aop_proxy_logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AtTypeSessionAop {

	@Pointcut("execution(* com.perform.svs.aop_session_test.controller.*AopAtController*.*(..))")
	private void pintCutTarget() {}

	@Around(value = "pintCutTarget()")
	public Object trace(ProceedingJoinPoint joinPoint) throws Throwable {
		
		HttpServletRequest request = null;
		
		// 적용될 메소드의 인자값중 HttpServletRequest 를 찾는다.
		for (Object o : joinPoint.getArgs()) {
			if (o instanceof HttpServletRequest) {
				request = (HttpServletRequest) o;
			}
		}
		
		System.out.println("before AOP Excute");
		
		if (request != null) {
			
			
			HttpSession session = request.getSession();
			String id = (String) session.getAttribute("id");
			
			if(id == null || "".equals(id)){
				
				System.out.println("Session Setting");
				session.setAttribute("id", "SIHYEON");
				
				/*10초간 세션 유지*/
				session.setMaxInactiveInterval(10);
			}
			
			// 로그인 페이지 제외 & 로그인 페이지 이돈
//			String strUrl = request.getRequestURL().toString();
//			if (!strUrl.endsWith("/login")) {
//				HttpSession session = request.getSession();
//				String loginId = (String) session.getAttribute("LoginId");
//				if (loginId == null || "".equals(loginId)) {
//					return "로그인페이지";
//				}
//			}
		}
		
		Object result = joinPoint.proceed();
		return result;
	}
}

package ks47team02.common.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Component
public class LoginInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		HttpSession session = request.getSession();
		String sessionId = (String) session.getAttribute("SID");
		String sessionCpId = (String) session.getAttribute("CPID");

		if(sessionId == null && sessionCpId == null) {
			response.sendRedirect("/login");
			return false;
		}
		return true;
	}
	/*
	 * else {
	 * String requestUri = request.getRequestURI();
	 * String sessionLevel = (String) session.getAttribute("SLEVEL");
	 *
	 * if(sessionLevel.equals("일반회원")) {
	 *
	 * } }
	 */


}
	

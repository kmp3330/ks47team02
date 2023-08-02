package ks47team02.common.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class AuthorityCheckInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();

        if (request.getRequestURI().equals("/checkAccess")) {
            String sessionId = (String) session.getAttribute("SID");

            // 일반 회원인 경우에만 접근 차단
            if (sessionId != null) {
                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");
                response.getWriter().write("{\"accessDenied\": true}");
                return false;
            }
        }
        return true;
    }
}


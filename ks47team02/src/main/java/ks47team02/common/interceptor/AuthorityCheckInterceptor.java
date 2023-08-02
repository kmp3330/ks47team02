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
            String sessionCpId = (String) session.getAttribute("CPID");

            // 기업회원인 경우 메뉴 생성
            if (sessionCpId != null) {
                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");
                response.getWriter().write("{\"accessAllowed\": true}");
                return true;
            }
        }
        return true;
    }
}


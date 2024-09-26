package fashion_shop.interceptor;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class SecurityUserInterceptor extends HandlerInterceptorAdapter{
//	@Override
//	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//		HttpSession session = request.getSession();
//		if(session.getAttribute("acc") == null) {
//			response.sendRedirect(request.getContextPath() + "/home/index.htm");
//			System.out.println("Do Login :)");
//			return false;
//		}
//		return true;
//	}
	
}
package interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class GreetingsInterceptor implements HandlerInterceptor {

	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Pre-handle");
        
		System.out.println(arg0.getRequestURI());
        return true;
	}
	
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("post-handle");
		System.out.println(arg0.getRequestURI());
		
	}
	
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("after-Completion");
	}
}

package stu.wl.twitter.web.filter;

import java.io.IOException;
import static stu.wl.twitter.cons.CommonConstant.*;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import stu.wl.twitter.cons.CommonConstant;
import stu.wl.twitter.domain.User;

//登陆过滤
public class LoginFilter implements Filter{

	@Override
	public void destroy() {}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		System.out.println("请求的url:"+req.getContextPath()+"请求的路径："+req.getRequestURI());

		User user = (User) req.getSession().getAttribute(USER_CONTEXT);
		if(user==null){
			HttpServletResponse res = (HttpServletResponse) response;
			res.sendRedirect("/Twitter/Login.jsp");
		}else{
			chain.doFilter(request, response);
		}
		
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {}
	public boolean isURLLogin(String url,HttpServletRequest request,HttpServletResponse response){

		return false;
	}
	
	public boolean isLoginURL(String url,HttpServletRequest request){
		
		return true;
	}
	
	public static boolean isValid(String strLink) { URL url; try {     url = new URL(strLink);     HttpURLConnection connt = (HttpURLConnection)url.openConnection();    connt.setRequestMethod("HEAD");     String strMessage = connt.getResponseMessage();    if (strMessage.compareTo("Not Found") == 0) {     return false;    }     connt.disconnect(); } catch (Exception e) {    return false; }  return true; } 

}

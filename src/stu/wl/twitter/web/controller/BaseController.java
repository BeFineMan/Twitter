package stu.wl.twitter.web.controller;

import javax.servlet.http.HttpServletRequest;

import stu.wl.twitter.cons.CommonConstant;
import stu.wl.twitter.domain.User;

public class BaseController {
	protected User getSessionUser(HttpServletRequest request){
		return (User) request.getSession().getAttribute(CommonConstant.USER_CONTEXT);
	}
	
	protected void setSessionUser(HttpServletRequest request, User user){
		request.getSession().setAttribute(CommonConstant.USER_CONTEXT, user);
	}
	protected void removeSessionUser(HttpServletRequest request){
		request.getSession().removeAttribute(CommonConstant.USER_CONTEXT);
	}
	protected String getContentType(HttpServletRequest request){
		return null; 
	}
	protected void updateSessionUser(HttpServletRequest request,User user){
		request.getSession().removeAttribute(CommonConstant.USER_CONTEXT);
		this.setSessionUser(request, user);
	}
}

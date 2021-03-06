package stu.wl.twitter.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sun.jna.platform.win32.WinDef.WORD;

import stu.wl.twitter.domain.User;
import stu.wl.twitter.exception.UserExistException;
import stu.wl.twitter.service.UserService;

@Controller
@RequestMapping("/login")
public class LoginController extends BaseController{
	@Autowired
	private UserService userService;

	//登陆
	@RequestMapping("/doLogin")
	public ModelAndView login(HttpServletRequest request, User user){
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println(username+password);
		ModelAndView mav = new ModelAndView();
		
		//如果用户已经登陆过，则直接跳转
		Object sessionUser = request.getSession().getAttribute("USER_CONTEXT");
		if(!(sessionUser == null || "".equals(sessionUser))){
			mav.setViewName("forward:/user/home.nolog");
			return mav;
		}
		
		User LoginUser = userService.getUserByName(user.getUserName());
		if (LoginUser == null || ! LoginUser.getPassword().equals(user.getPassword())) {
			//跳转本页面，但是弹出提示 账号密码不对提示注册
			request.getSession().setAttribute("errorMsg", "用户名或密码不正确");
			mav.setViewName("redirect:/Login.jsp");
		}else{
			//用户名和密码匹配，登陆成功
			mav.setViewName("forward:/user/home.log");
			super.setSessionUser(request, LoginUser);
		}
		return mav;
	}
	
	//注销
	@RequestMapping("/logout")
	public ModelAndView logout(HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		super.removeSessionUser(request);
		mav.setViewName("redirect:/Login.jsp");
		return mav;
	}
	
	
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
}










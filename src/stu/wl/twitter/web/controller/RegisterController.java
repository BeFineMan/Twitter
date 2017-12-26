package stu.wl.twitter.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import stu.wl.twitter.domain.User;
import stu.wl.twitter.exception.UserExistException;
import stu.wl.twitter.service.UserService;

@Controller
@RequestMapping("/register")
public class RegisterController extends BaseController{
	@Autowired
	private UserService userService;

	//注册用户
	@RequestMapping(value = "/res", method = RequestMethod.POST)
	public ModelAndView regisster(HttpServletRequest request, User user){
		System.out.println(user);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("forward:/login.jsp");
		
		try {
			userService.register(user);
			this.setSessionUser(request, user);
		} catch (UserExistException e) {
			mav.addObject("errorMsg","用户名已存在，请选择其他名字");
			mav.setViewName("redirect:/Login.jsp");
		}
		return mav;
	}
	
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
}

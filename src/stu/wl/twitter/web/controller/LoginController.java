package stu.wl.twitter.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sun.jna.platform.win32.WinDef.WORD;

import stu.wl.twitter.domain.User;
import stu.wl.twitter.service.UserService;

@Controller
@RequestMapping("/login")
public class LoginController {
	@Autowired
	private UserService userService;

	@RequestMapping("/doLogin")
	public ModelAndView login(HttpServletRequest request, User user){
		System.out.println(user);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("User/UserShow");
		
		User LoginUser = userService.getUserByName(user.getUserName());
		
		if (LoginUser == null || ! LoginUser.getPassword().equals(user.getPassword())) {
			mav.addObject("errorMsg","用户名或密码不正确");
			mav.setViewName("forward:/Login.jsp");
			//跳转本页面，但是弹出提示 账号密码不对提示注册
		}
		/*
		else {
			//跳转到用户页面
		}
		*/
		return mav;
	}
	
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
}










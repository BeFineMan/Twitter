package stu.wl.twitter.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import stu.wl.twitter.domain.BaseInfo;
import stu.wl.twitter.domain.ConcernInfo;
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
	public ModelAndView regisster(HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/Login.jsp");
		String userName = request.getParameter("userName");
		String password =  request.getParameter("password");
		
		HttpSession session  = request.getSession();
		
		if(userName == null || "".equals(userName) || password == null || "".equals(password)
				|| "用户".equals(userName) || "密码".equals(password)){
			session.setAttribute("checkError","用户名或密码不能为空");
			return mav;
		}
		
		User user = new User();
		user.setUserName(userName);
		user.setPassword(password);
		user.setBaseInfo(new BaseInfo());
		user.setConcernInfo(new ConcernInfo());
		
		try {
			userService.register(user);
		} catch (UserExistException e) {
			session.setAttribute("errorMsg","用户名已存在，请选择其他名字");
			return mav;
		}
		
		session.setAttribute("regsiterSuccess", "注册成功");
		return mav;
	}
	
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
}

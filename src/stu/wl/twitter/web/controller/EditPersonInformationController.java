package stu.wl.twitter.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import stu.wl.twitter.dao.UserDao;
import stu.wl.twitter.domain.User;

@Controller
@RequestMapping("/edit")
public class EditPersonInformationController extends BaseController{
	@Autowired
	private UserDao userdao;
	
	@RequestMapping("/person")
	public ModelAndView ShowPersonInformation(HttpServletRequest request){
		User user = userdao.get(super.getSessionUser(request).getUserid());

		ModelAndView mav = new ModelAndView();
		mav.setViewName("User/showInfo");
		mav.addObject("user", user);
		
		return mav;
		
	}
	public UserDao getUserdao() {
		return userdao;
	}
	public void setUserdao(UserDao userdao) {
		this.userdao = userdao;
	}
}

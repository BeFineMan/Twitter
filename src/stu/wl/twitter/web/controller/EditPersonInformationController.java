package stu.wl.twitter.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Enumeration;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import stu.wl.twitter.dao.UserDao;
import stu.wl.twitter.domain.User;

@Controller
@RequestMapping("/edit")
public class EditPersonInformationController extends BaseController{	//编辑个人信息
	@Autowired
	private UserDao userdao;
	
	//显示个人信息
	@RequestMapping(value = "/person")
	public ModelAndView ShowPersonInformation(HttpServletRequest request){
		User user = userdao.get(super.getSessionUser(request).getUserid());

		ModelAndView mav = new ModelAndView();
		mav.setViewName("User/showInfo");
		
		mav.addObject("user", user);
		return mav;
		
	}
	
	//测试
	@RequestMapping(value = "/test")
	public ModelAndView test(HttpServletRequest request, HttpServletResponse response, RedirectAttributes attr){
		ModelAndView mav = new ModelAndView();
		attr.addFlashAttribute("test5","第五次测试");	
		request.getSession().setAttribute("test7", "第七次测试");
		mav.setViewName("redirect:/test.jsp");
		return mav;
	}
	
	//更新个人信息
	@RequestMapping("/updateUserInfo")
	public ModelAndView updatePersonInformation(HttpServletRequest request){
		Enumeration<String> params = request.getParameterNames();
		while(params.hasMoreElements()){
			String param = params.nextElement();
			System.out.println("参数名："+param+"参数值:"+request.getParameter(param));
		}
		//User user = userdao.get(super.getSessionUser(request).getUserid());

		ModelAndView mav = new ModelAndView();
		mav.setViewName("User/showInfo");	
		//mav.addObject("user", user);
		
		//getUserdao().update(user);
		return mav;
		
	}
	
	
	public UserDao getUserdao() {
		return userdao;
	}
	public void setUserdao(UserDao userdao) {
		this.userdao = userdao;
	}
}

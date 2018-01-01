package stu.wl.twitter.web.controller;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import stu.wl.twitter.dao.UserDao;
import stu.wl.twitter.domain.BaseInfo;
import stu.wl.twitter.domain.User;
import stu.wl.twitter.exception.UserExistException;

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
	public ModelAndView updatePersonInformation(HttpServletRequest request)throws UserExistException{
		ModelAndView mav = new ModelAndView();

		User user = userdao.get(super.getSessionUser(request).getUserid()); 
		
		//获取基本信息属性
		BaseInfo baseInfo = user.getBaseInfo();
		if(baseInfo == null){
			baseInfo = new BaseInfo();
			baseInfo.setUserid(user.getUserid());
			user.setBaseInfo(baseInfo);
		}
		
		/*
		 * 将传来的参数赋值进基本信息里
		 * 这样做不妥，目的只是为了回顾java动态反射等，可以直接静态赋值，简单粗暴
		 */
		Enumeration<String> params = request.getParameterNames();
		StringBuffer sbf = null;
		while(params.hasMoreElements()){
			String param = params.nextElement();
			sbf = new StringBuffer("set"+param);
			sbf.replace(3, 4, sbf.substring(3, 4).toUpperCase());
			
			Method method = null;

			try{
				switch(param){
					case "birthday":{
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-DD-mm");
						Date date = sdf.parse(request.getParameter(param));
						method = baseInfo.getClass().getMethod(sbf.toString(),Date.class);
						method.invoke(baseInfo,date);
						break;
					}
					case "sex":{
						char sex = request.getParameter(param).charAt(0);
						method = baseInfo.getClass().getMethod(sbf.toString(),char.class);
						method.invoke(baseInfo,sex);
						break;
					}
					default:{
						method = baseInfo.getClass().getMethod(sbf.toString(),String.class);
						method.invoke(baseInfo,request.getParameter(param));
					}
				}
			}catch(Exception e){
				e.printStackTrace();
				throw new UserExistException("678");
			}
		}
		
		userdao.update(user);
		
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

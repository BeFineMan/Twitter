package stu.wl.twitter.web.controller;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
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
	private ModelAndView mav;
	
	//显示个人信息
	@RequestMapping(value = "/person")
	public ModelAndView ShowPersonInformation(HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("User/showInfo");
		
		return mav;
		
	}
	
	
	//更新个人信息
	@RequestMapping("/updateUserInfo")
	public ModelAndView updatePersonInformation(HttpServletRequest request,@Valid BaseInfo baseinfo,BindingResult basebind)throws UserExistException{
		mav = new ModelAndView();
		mav.setViewName("forward:/edit/person.log");

		
		FieldError error = basebind.getFieldError("sex");
		if(error!=null){
			request.getSession().setAttribute("sexError", "性别属性有误");
			return mav;
		}

		User user = userdao.get(super.getSessionUser(request).getUserid()); 
		
		//获取基本信息属性
		BaseInfo baseInfo = user.getBaseInfo();
		if(baseInfo == null){
			baseInfo = new BaseInfo();
			baseInfo.setUserid(user.getUserid());
		}
		user.setBaseInfo(baseInfo);

		String date = baseinfo.getBirthday();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-DD-mm");
		try{
			sdf.parse(date);	
		}catch(Exception e){
			return mav;
		}
		
		userdao.update(user);
		return mav;
		
	}
	
	
	public UserDao getUserdao() {
		return userdao;
	}
	public void setUserdao(UserDao userdao) {
		this.userdao = userdao;
	}
}

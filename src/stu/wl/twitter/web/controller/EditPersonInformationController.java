package stu.wl.twitter.web.controller;

import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import stu.wl.twitter.dao.BaseInfoDao;
import stu.wl.twitter.dao.UserDao;
import stu.wl.twitter.domain.BaseInfo;
import stu.wl.twitter.domain.User;
import stu.wl.twitter.exception.UserExistException;

@Controller
@RequestMapping("/edit")
public class EditPersonInformationController extends BaseController{	//编辑个人信息
	@Autowired
	private UserDao userdao;
	@Autowired
	private BaseInfoDao baseInfoDao;
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
		System.out.println("测试:"+request.getServletContext().getContextPath()+"真实路径:"+request.getServletContext().getRealPath("/"));
		
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
		
		//日期格式检查 
		String date = baseinfo.getBirthday();
		if(!(date == null || "".equals(date))){		
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-DD-mm");
			try{
				sdf.parse(date);	
			}catch(Exception e){
				request.getSession().setAttribute("errorDate", "日期格式不正确");
				return mav;
			}
		}

		baseInfo.setBirthday(baseinfo.getBirthday());
		baseInfo.setNickName(baseinfo.getNickName());
		baseInfo.setRealName(baseinfo.getRealName());
		baseInfo.setSex(baseinfo.getSex());
		baseInfo.setSimpleinfo(baseinfo.getSimpleinfo());
		
		baseInfoDao.update(baseInfo);
		super.updateSessionUser(request, user);
		return mav;
		
	}
	
	
	public UserDao getUserdao() {
		return userdao;
	}
	public void setUserdao(UserDao userdao) {
		this.userdao = userdao;
	}


	public BaseInfoDao getBaseInfoDao() {
		return baseInfoDao;
	}


	public void setBaseInfoDao(BaseInfoDao baseInfoDao) {
		this.baseInfoDao = baseInfoDao;
	}
}

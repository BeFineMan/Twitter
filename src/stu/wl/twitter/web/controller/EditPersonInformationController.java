package stu.wl.twitter.web.controller;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;

import javax.json.JsonObject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sun.jna.platform.win32.WinDef.WORD;

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
	@RequestMapping(value = "/person",method = RequestMethod.POST)
	public ModelAndView ShowPersonInformation(HttpServletRequest request){
		User user = userdao.get(super.getSessionUser(request).getUserid());

		ModelAndView mav = new ModelAndView();
		mav.setViewName("User/showInfo");
		
		mav.addObject("user", user);
		request.setAttribute("a", "abcd");
		

		return mav;
		
	}
	
	@RequestMapping("/json")
	public void testJson(HttpServletRequest request,HttpServletResponse response){
		JSONObject json = new JSONObject();
		JSONArray jsonarray = new JSONArray();
		json.put("abc", "ABCDEFG");
		jsonarray.add(json);
		
		PrintWriter out = null;
		try {
			out = response.getWriter();
			out.println(jsonarray);
			out.println("阿三大苏打撒");
			out.close();
			request.getRequestDispatcher("test.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
		
	}
	
	@RequestMapping("/EditInfo")
	public ModelAndView EditPersonInformation(HttpServletRequest request,User users){
		User user = userdao.get(super.getSessionUser(request).getUserid());

		ModelAndView mav = new ModelAndView();
		mav.setViewName("User/personInformation");
		mav.addObject("user", user);
		
		getUserdao().update(user);
		
		return mav;
		
	}
	
	
	public UserDao getUserdao() {
		return userdao;
	}
	public void setUserdao(UserDao userdao) {
		this.userdao = userdao;
	}
}

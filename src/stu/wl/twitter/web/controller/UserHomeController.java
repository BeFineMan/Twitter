package stu.wl.twitter.web.controller;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import stu.wl.twitter.dao.DynamicDao;
import stu.wl.twitter.dao.UserDao;
import stu.wl.twitter.domain.Dynamic;
import stu.wl.twitter.domain.User;

@Controller
@RequestMapping("/user")
public class UserHomeController extends BaseController{
	@Autowired
	private DynamicDao dynamicDao;
	@Autowired
	private UserDao userdao;
	private ModelAndView mav = null;
	
	//返回主页
	@RequestMapping("/home")
	public ModelAndView enterUserHome(HttpServletRequest request,HttpServletResponse response) throws IOException{
		mav = new ModelAndView();
		mav.setViewName("User/userhome");
		User user = super.getSessionUser(request);
		request.setAttribute("dynamics",dynamicDao.getDynamicsByUserByfocus(user));
		return mav;
	}

	//发表动态
	@RequestMapping(value = "/publishDynamic", method = RequestMethod.POST)
	public ModelAndView publishDynamic(HttpServletRequest request, HttpServletResponse response) throws IOException{
		mav = new ModelAndView();
		mav.setViewName("User/userhome");
		String dString = request.getParameter("content");
		System.out.print(dString);
		mav.setViewName("forward:/user/home.log");
		System.out.println("111");
		return mav;
	}
	
	//上传头像
	@RequestMapping("/uploadIcon")
	public ModelAndView uploadIcon(HttpServletRequest request,HttpServletResponse response,HttpSession session){
		mav = new ModelAndView();
		mav.setViewName("User/userhome");
		
		DiskFileItemFactory factory = new DiskFileItemFactory();	//创建磁盘工厂
		ServletFileUpload upload = new ServletFileUpload(factory);		//创建处理工具
		//upload.setFileSizeMax(3145728);	//设置最大上传大小	3M:3*1024*1024
		List<FileItem> items = null;
		try {
			items = upload.parseRequest(request);
		} catch (FileUploadException e) {
			e.printStackTrace();
		}
		Iterator<FileItem> iter = items.iterator();
		while(iter.hasNext()){
			FileItem item = iter.next();
			String fieldName = item.getFieldName();		//得到表单控件的名称
			System.out.println("表单控件名称"+fieldName);
			if(!item.isFormField()){
				String fileName = item.getName();
				String contentType = item.getContentType();
				long size = item.getSize();
				System.out.println("fileName:"+fileName+"contentType:"+contentType+",size:"+size);
			}else{
				String value = item.getString();
				System.out.println("value:"+value);
			}
		}
		return mav;
	}
	
	@RequestMapping("/test")
	public String test(HttpServletRequest request,HttpServletResponse response,HttpSession session,WebRequest web){
		
		DiskFileItemFactory factory = new DiskFileItemFactory();	//创建磁盘工厂
		ServletFileUpload upload = new ServletFileUpload(factory);		//创建处理工具
		upload.setFileSizeMax(3145728);	//设置最大上传大小	3M:3*1024*1024
		List<FileItem> items = null;
		try {
			items = upload.parseRequest(request);
		} catch (FileUploadException e) {
			e.printStackTrace();
		}
		Iterator<FileItem> iter = items.iterator();
		while(iter.hasNext()){
			FileItem item = iter.next();
			String fieldName = item.getFieldName();		//得到表单控件的名称
			System.out.println("表单控件名称"+fieldName);
			if(!item.isFormField()){
				String fileName = item.getName();
				String contentType = item.getContentType();
				long size = item.getSize();
				System.out.println("fileName:"+fileName+"contentType:"+contentType+"size:"+size);
			}else{
				String value = item.getString();
				System.out.println("value:"+value);
			}
		}
		System.out.println("我没有跳转");
		return null;
	}
	
	/*获取关注的人*/
	@RequestMapping("/getFocus")
	public ModelAndView getFoucs(HttpServletRequest request,HttpServletResponse response,HttpSession session,WebRequest web){
		User user = super.getSessionUser(request);
		List<User> list = userdao.getFocusByUser(user);
		mav = new ModelAndView();

		mav.setViewName("User/focus");
		request.setAttribute("focus", list);
		return mav;
	}
	
	
	public UserDao getUserdao() {
		return userdao;
	}

	public void setUserdao(UserDao userdao) {
		this.userdao = userdao;
	}

	public DynamicDao getDynamicDao() {
		return dynamicDao;
	}

	public void setDynamicDao(DynamicDao dynamicDao) {
		this.dynamicDao = dynamicDao;
	}
	
	
}

package stu.wl.twitter.web.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import stu.wl.twitter.dao.DynamicDao;
import stu.wl.twitter.dao.UserDao;
import stu.wl.twitter.domain.Dynamic;
import stu.wl.twitter.domain.User;
import stu.wl.twitter.service.DynamicService;

@Controller
@RequestMapping("/user")
public class UserHomeController extends BaseController{
	@Autowired
	private DynamicDao dynamicDao;
	@Autowired
	private DynamicService dynamicService;
	@Autowired
	private UserDao userdao;
	private ModelAndView mav = null;
	
	//返回主页
	@RequestMapping("/home")
	public ModelAndView enterUserHome(HttpServletRequest request,HttpServletResponse response) throws IOException{
		mav = new ModelAndView();
		mav.setViewName("User/userhome");
		User user = super.getSessionUser(request);
		request.setAttribute("dynamics",dynamicDao.getDynamicsByUserAndFocus(user));
		return mav;
	}

	@RequestMapping("/focusDynamics")
	public ModelAndView enterUserHomeAndGetFocusDynamics(HttpServletRequest request,HttpServletResponse response) throws IOException{
		mav = new ModelAndView();
		mav.setViewName("User/userhome");
		User user = super.getSessionUser(request);
		request.setAttribute("dynamics",dynamicDao.getDynamicsByUserByfocus(user));
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

			if(!item.isFormField()){		//如果是表单文件
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
	

	//发表动态
	@RequestMapping(value = "/publishDynamic", method = RequestMethod.POST)
	public ModelAndView publishDynamic(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws UnsupportedEncodingException{
		mav = new ModelAndView();
		mav.setViewName("forward:/user/home.log");
		
		DiskFileItemFactory factory = new DiskFileItemFactory();	//创建磁盘工厂
		ServletFileUpload upload = new ServletFileUpload(factory);		//创建处理工具

		List<FileItem> items = null;
		Dynamic dynamic = new Dynamic();
		InputStream in = null;
		
		try {
			items = upload.parseRequest(request);
		} catch (FileUploadException e) {
			e.printStackTrace();
		}
		
		String imageFormat = null;
		String content = null;
		Iterator<FileItem> iter = items.iterator();
		while(iter.hasNext()){
			FileItem item = iter.next();

			if(!item.isFormField()){		//如果是文件
				String fileName = item.getName();
				if(!(fileName == null || "".equals(fileName))){		
					int point = fileName.lastIndexOf(".");
					if(point >= 0){
						imageFormat = fileName.substring(point);
					}
					
					if(!(".png".equals(imageFormat)||".jpg".equals(imageFormat) || ".gif".equals(imageFormat))){	//上传的不是图片
						request.getSession().setAttribute("imageFomatError", "上传的格式不正确，请上传图片");
						return mav;
					}
					if(item.getSize() > 3145728){		//文件大小超过3M
						request.getSession().setAttribute("imageSizeError", "图片的大小不能超过3M");
						return mav;
					}
					try {
						in = item.getInputStream();
					} catch (IOException e) {
						System.out.println("没有获得输入流");
						e.printStackTrace();
						return mav;
					}
				}
				
			}else{
				content = item.getString("UTF-8");
			}
		}
		
		dynamic.setContent(content);
		dynamic.setPath(imageFormat);
		dynamic.setUser(super.getSessionUser(request));		
		dynamic.setLike_number(0);
		dynamicService.publishDynamic(dynamic, in); 
		return mav;
	}
	
	/*获取关注的人*/
	@RequestMapping("/getFocus")
	public ModelAndView getFoucs(HttpServletRequest request,HttpServletResponse response,HttpSession session,WebRequest web){
		mav = new ModelAndView();
		mav.setViewName("User/focusList");

		User user = super.getSessionUser(request);
		List<User> users = userdao.getFocusByUser(user);
		
		for(User u : users){
			System.out.println("用户-------："+u);
		}
		
		request.setAttribute("focus", users);
		return mav;
	}
	
	
	/*获取关注的人的动态*/
	@RequestMapping("/getFocusDynamic")
	public ModelAndView getFocusDynamic(HttpServletRequest request,HttpServletResponse response,HttpSession session,WebRequest web){
		String id = request.getParameter("id");
		User user = userdao.get(id);
		List dynamicList=user.getDynamics();
		
		mav = new ModelAndView();
		request.setAttribute("dynamics", dynamicList);
		mav.setViewName("User/focushome");
		
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

	public DynamicService getDynamicService() {
		return dynamicService;
	}

	public void setDynamicService(DynamicService dynamicService) {
		this.dynamicService = dynamicService;
	}
	
	
}

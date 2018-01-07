package stu.wl.twitter.web.controller;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import stu.wl.twitter.domain.User;

@Controller
@RequestMapping("/user")
public class UserHomeController extends BaseController{
	private ModelAndView mav = null;
	
	//返回主页
	@RequestMapping("/home")
	public ModelAndView enterUserHome(HttpServletRequest request){
		mav = new ModelAndView();
		mav.setViewName("User/userhome");
		
		User user = super.getSessionUser(request);
		return mav;
	}

	//发表动态
	@RequestMapping("/publishDynamic")
	public ModelAndView publishDynamic(){
		mav = new ModelAndView();
		return mav;
	}
	
	//上传头像
	@RequestMapping("/uploadIcon")
	public ModelAndView uploadIcon(HttpServletRequest request,HttpServletResponse response,HttpSession session,WebRequest web){
		mav = new ModelAndView();
		mav.setViewName("User/userhome");
		
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
	
}

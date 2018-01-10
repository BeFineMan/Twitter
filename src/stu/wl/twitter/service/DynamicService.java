package stu.wl.twitter.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import stu.wl.twitter.dao.DynamicDao;
import stu.wl.twitter.domain.Dynamic;
import stu.wl.twitter.util.TwitterUtil;

@Service("dynamicService")
public class DynamicService {
	@Autowired
	private DynamicDao dynamicDao;

	//发表动态
	public boolean publishDynamic(Dynamic dynamic,InputStream in){
		dynamic.setDeliver_time(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		//文件名:xxxxx.png或xxx.jpg
		StringBuffer fileName = new StringBuffer(TwitterUtil.getSystemTime()+dynamic.getPath());
		
		if(in != null){
			//获取类的路径
			StringBuffer realPath = new StringBuffer(DynamicService.class.getResource("/").getPath());	
			
			//文件上传的路径
			StringBuffer uploadPath  = new StringBuffer(realPath.substring(0, realPath.indexOf("WEB-INF/classes/")));
			
			//图片保存的路径
			StringBuffer imagePath = new StringBuffer("/Twitter/");
			
			//创建文件夹
			StringBuffer filedir = new StringBuffer();
			filedir.append(imagePath.append("dynamicImage/").append(dynamic.getUser().getUserid()).append("/"));
			
			
			imagePath.append("dynamicImage/").append(dynamic.getUser().getUserid()).append("/"+fileName);
			filedir = uploadPath.append("dynamicImage/").append(dynamic.getUser().getUserid()).append("/");
			
			File file = new File(filedir.toString().replaceAll("/", "\\\\"));
			file.mkdir();
			uploadPath.append(fileName);
			System.out.println(uploadPath);
			System.out.println(filedir.toString().replaceAll("/", "\\\\"));
			if(this.saveFile(uploadPath.toString(),in)==false){
				System.out.println("文件保存失败");
				return false;
			} 
			dynamic.setPath(imagePath.toString());
		}
		
		dynamicDao.save(dynamic);
		return true;
	}
	
	//保存文件
	public boolean saveFile(String path,InputStream in){
		System.out.println("最终路径："+path);
		File file = new File(path);
		
		if(file.exists()){		//如果文件存在，则删除
			file.delete();
		}
		
		try {
			file.createNewFile();		//创建文件
		} catch (IOException e) {
			System.out.println("文件创建失败");
			e.printStackTrace();
		}
		
		//边读边写
		int t = 0;
		try{
			OutputStream out = new FileOutputStream(file);
			while((t = in.read())!=-1){
				out.write(t);
				}
			in.close();
			out.close();
		}catch(Exception e){
			System.out.println("文件上传失败");
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public DynamicDao getDynamicDao() {
		return dynamicDao;
	}

	public void setDynamicDao(DynamicDao dynamicDao) {
		this.dynamicDao = dynamicDao;
	}
	
}

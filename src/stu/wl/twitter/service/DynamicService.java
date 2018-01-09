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

@Service("dynamicService")
public class DynamicService {
	@Autowired
	private DynamicDao dynamicDao;

	public boolean publishDynamic(Dynamic dynamic,InputStream in){
		dynamic.setDeliver_time(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		String fileName = dynamic.getPath();
		
		if(in != null){
			//获取类的路径
			StringBuffer realPath = new StringBuffer(DynamicService.class.getResource("/").getPath());	
			System.out.println("------真实路径:"+realPath);
			
			StringBuffer uploadPath  = new StringBuffer(realPath.substring(0, realPath.indexOf("WEB-INF/classes/")));
			StringBuffer imagePath = new StringBuffer("/Twitter");
			System.out.println("uploadPath:"+uploadPath.toString());
			imagePath.append("dynamicImage\\").append(dynamic.getUser().getUserid()).append("\\"+fileName);
			uploadPath.append("dynamicImage\\").append(dynamic.getUser().getUserid()).append("\\"+fileName);
			System.out.println("--------文件路径:"+uploadPath.toString()+",-------图片路径:"+imagePath.toString());
			if(this.saveFile(uploadPath.toString(),in)==false){
				System.out.println("文件保存失败");
				return false;
			} 
		}
		
		dynamicDao.save(dynamic);
		return true;
	}
	
	public boolean saveFile(String path,InputStream in){
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

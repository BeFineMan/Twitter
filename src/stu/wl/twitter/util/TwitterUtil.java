package stu.wl.twitter.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class TwitterUtil {
	//获取时间戳+3个随机数
		public static String getSystemTime(){
			String date = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
			StringBuffer sbf=new StringBuffer(date);
			
			Random rand = new Random();
			for(int i=0;i<3;i++){
				sbf.append(rand.nextInt(10));
			}
			return sbf.toString();
		}
}

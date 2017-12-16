package Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Test2 {
	public static void main(String args[]){
		String date = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
		Random rand = new Random();
		StringBuffer sbf=new StringBuffer(date);
		for(int i=0;i<3;i++){
			sbf.append(rand.nextInt(10));
		}
		System.out.println(sbf);
	}
}

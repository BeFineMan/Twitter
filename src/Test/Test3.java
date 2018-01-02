package Test;

import java.lang.reflect.Method;

import stu.wl.twitter.domain.BaseInfo;

public class Test3 {
	public static void main(String args[]) throws Exception{
		String str[] = {"login","regsiter"};
		String test1 = "/Twitter/login/login.log";
		String test2 = "/Twitter/register/register.log";
		String test3 = "/Twitter/edit/register.log";
		
		StringBuffer sbf = new StringBuffer(test1);

		for(int i = 0;i<str.length;i++){
			String suffix = sbf.substring(9);
			String prefix = suffix.indexOf("/");
		}
		
		String st =t1.substring(0, t1.indexOf("/"));
		System.out.println(st);
	}
}

package Test;

import java.io.File;

public class Test3 {
	public static void main(String args[]) throws Exception{
		String aaa = "asdasd/adasdasda/sdas/dasdasd/asd/asdas///asdasdasdasd";
		System.out.println("\\");
		System.out.println(aaa.replaceAll("/", "\\\\"));
	}
}

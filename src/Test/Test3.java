package Test;

import java.io.File;

public class Test3 {
	public static void main(String args[]) throws Exception{
		File file = new File("D:\\Capture001.png");
		System.out.println(file.createNewFile());
	}
}

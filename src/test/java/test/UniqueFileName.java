package test;

import java.io.File;

public class UniqueFileName {

	public static void main(String[] args) {
		String file1 = "abc.jpg";
		System.out.println(System.nanoTime());
		//6331561971600
		System.out.println(System.currentTimeMillis());
		//1609810835783
		System.out.println(System.currentTimeMillis()+"_"+System.nanoTime());
		file1 += "_" + System.currentTimeMillis()+"_"+System.nanoTime();
		System.out.println(file1);
		File file = new File("D:\\upload\\"+file1);
		if (!file.exists()) {
			file.mkdir();
		}
	}

}

package lixin.gan;

import java.io.File;
import java.io.IOException;

public class UseFile {
	public static void main(String[] args) throws IOException {
		File file = new File("E:/data.txt");
		file = new File("E:\\data.txt");
		
		
		// 打印项目路径
		System.out.println(System.getProperty("user.dir"));
		// E:\simpleEclipseWordSpace\Test
		
		File f1 = new File("add.txt");
		// 默认是在项目下创建文件
		f1.createNewFile();
		
		/*
		File f2 = new File("d:/a/b/c.txt");
		f2.mkdir(); // 只要有一个目录不存在，则创建失败
		f2.mkdirs(); // 如果有目录不存在，那么就创建目录
		*/
	}
}

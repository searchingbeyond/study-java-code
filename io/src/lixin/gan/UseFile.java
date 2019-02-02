package lixin.gan;

import java.io.File;
import java.io.IOException;

public class UseFile {
	
	public static void useSeparator() {
		System.out.println(File.separator);
		System.out.println(File.pathSeparator);
		
		// 推荐使用格式 
		String path = "E:/a/b/c.txt";
		System.out.println(path);
	}
	
	public static void useFileBasic() {
		String path = "E:/simpleEclipseWordSpace/IO/data.txt";
		File file = new File(path);
		try {
			file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		file = new File("E:/simpleEclipseWordSpace/", "IO/data.txt");
		file = new File("E:/simpleEclipseWordSpace/IO", "data.txt");
	}
	
	public static void useFileAPI() {
		String path = "E:/simpleEclipseWordSpace/IO/data.txt";
		File file = new File(path);
		
		// 名称信息
		System.out.println("getName -> " + file.getName());
		System.out.println("getPath -> " + file.getPath());
		System.out.println("getAbsolutePath -> " + file.getAbsolutePath());
		System.out.println("getParent -> " + file.getParent());
		
		// 判断状态
		System.out.println("exists -> " + file.exists());
		System.out.println("isFile -> " + file.isFile());
		System.out.println("isDirectory -> " + file.isDirectory());
		
		// 文件信息
		System.out.println("length -> " + file.length()); // 单位字节，length为0，可能是文件不存在，也可能是该路径表示的是文件夹
		System.out.println("canRead -> " + file.canRead());
		System.out.println("canWrite -> " + file.canWrite());
		
		// 文件操作
		File newFile = new File("test.txt");
		boolean created = false;
		try {
			// 不存在则创建成功
			created = newFile.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("success -> " + created);
		
		// 删除文件,已经存在的路径
		boolean deleted = false;
		deleted = newFile.delete();
		System.out.println("deleted -> " + deleted);
	
	}
	
	public static void createDirectory() {
		// 使用mkdir和mkdirs来创建目录，区别如下：
		// 使用mkdir来创建目录时，如果path中任意一个目录不存在，则创建失败
		// 使用mkdirs来创建目录时，如果path中的目录不存在，则会创建目录
		String path = "E:/demo/test";
		File directory = new File(path);
		directory.mkdirs();
		directory.mkdir();
	}
	
	public static void directoryOperation() {
		String path = "E:/eclipseWorkspace";
		File dir = new File(path);
		
		// 使用list()返回下一级的文件名或者目录名
		String[] subNames = dir.list();
		for (String s : subNames) {
			System.out.println(s);
		}
		
		// 使用list()返回下一级的文件或者目录的File对象
		File[] subFiles = dir.listFiles();
		for (File f : subFiles) {
			System.out.println(f.getAbsolutePath());
		}
		
		// 列出所有盘符
		File[] roots = dir.listRoots();
		for (File f : roots) {
			System.out.println(f.getAbsolutePath());
		}
	}
	
	// 扫描目录
	public static void scanDirectory(File src) {
		System.out.println(src.getAbsolutePath());
		if (null == src || !src.exists()) {
			return;
		} else if (src.isDirectory()){
			for (File s : src.listFiles()) {
				scanDirectory(s);
			}
		}
	}
	
	public static void main(String[] args) {
		try {
			System.out.println("aaa");
			return;
		} catch (Exception e) {
			e.getMessage();
		} finally {
			System.out.println("hello");
		}
	}
	
}

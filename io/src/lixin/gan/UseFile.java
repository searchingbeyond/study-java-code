package lixin.gan;

import java.io.File;
import java.io.IOException;

public class UseFile {
	
	public static void useSeparator() {
		System.out.println(File.separator);
		System.out.println(File.pathSeparator);
		
		// �Ƽ�ʹ�ø�ʽ 
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
		
		// ������Ϣ
		System.out.println("getName -> " + file.getName());
		System.out.println("getPath -> " + file.getPath());
		System.out.println("getAbsolutePath -> " + file.getAbsolutePath());
		System.out.println("getParent -> " + file.getParent());
		
		// �ж�״̬
		System.out.println("exists -> " + file.exists());
		System.out.println("isFile -> " + file.isFile());
		System.out.println("isDirectory -> " + file.isDirectory());
		
		// �ļ���Ϣ
		System.out.println("length -> " + file.length()); // ��λ�ֽڣ�lengthΪ0���������ļ������ڣ�Ҳ�����Ǹ�·����ʾ�����ļ���
		System.out.println("canRead -> " + file.canRead());
		System.out.println("canWrite -> " + file.canWrite());
		
		// �ļ�����
		File newFile = new File("test.txt");
		boolean created = false;
		try {
			// �������򴴽��ɹ�
			created = newFile.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("success -> " + created);
		
		// ɾ���ļ�,�Ѿ����ڵ�·��
		boolean deleted = false;
		deleted = newFile.delete();
		System.out.println("deleted -> " + deleted);
	
	}
	
	public static void createDirectory() {
		// ʹ��mkdir��mkdirs������Ŀ¼���������£�
		// ʹ��mkdir������Ŀ¼ʱ�����path������һ��Ŀ¼�����ڣ��򴴽�ʧ��
		// ʹ��mkdirs������Ŀ¼ʱ�����path�е�Ŀ¼�����ڣ���ᴴ��Ŀ¼
		String path = "E:/demo/test";
		File directory = new File(path);
		directory.mkdirs();
		directory.mkdir();
	}
	
	public static void directoryOperation() {
		String path = "E:/eclipseWorkspace";
		File dir = new File(path);
		
		// ʹ��list()������һ�����ļ�������Ŀ¼��
		String[] subNames = dir.list();
		for (String s : subNames) {
			System.out.println(s);
		}
		
		// ʹ��list()������һ�����ļ�����Ŀ¼��File����
		File[] subFiles = dir.listFiles();
		for (File f : subFiles) {
			System.out.println(f.getAbsolutePath());
		}
		
		// �г������̷�
		File[] roots = dir.listRoots();
		for (File f : roots) {
			System.out.println(f.getAbsolutePath());
		}
	}
	
	// ɨ��Ŀ¼
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

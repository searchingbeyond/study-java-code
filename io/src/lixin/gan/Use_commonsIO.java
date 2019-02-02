package lixin.gan;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.DirectoryFileFilter;
import org.apache.commons.io.filefilter.FileFilterUtils;
import org.apache.commons.io.filefilter.PrefixFileFilter;
import org.apache.commons.io.filefilter.SuffixFileFilter;


public class Use_commonsIO {
	public static void main(String[] args) {
		copyFileOrDirctory();
		
	}

	/**
	 * ��ȡ�ļ�����Ŀ¼�Ĵ�С����λ���ֽ�
	 */
	public static void getSize() {
		long size = FileUtils.sizeOf(new File("E:/"));
		System.out.println(size);  // byte
	}
	
	/**
	 * ��ȡ�ļ�����
	 */
	public static void readContent() {
		try {
			String msg = FileUtils.readFileToString(new File("demo.txt"), "utf-8");
			byte[] data = FileUtils.readFileToByteArray(new File("demo.txt"));
			List<String> msgs = FileUtils.readLines(new File("demo.txt"), "utf-8");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * ������д���ļ�
	 */
	public static void writeData() {
		/*
		FileUtils.write(file, data, encoding);
		FileUtils.write(file, data, append);
		*/
		try {
			FileUtils.write(new File("hello.txt"), "hello world", "utf-8", true);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * �����ļ�����Ŀ¼
	 */
	public static void copyFileOrDirctory() {
		try {
			//FileUtils.copyFile(new File("hello.txt"), new File("hello_copy.txt"));
			
			// ������������Ŀ¼
			// FileUtils.copyDirectory(new File("src"), new File("src_bak"));
			
			// ��Ŀ¼����������Ŀ¼��
			// FileUtils.copyDirectoryToDirectory(new File("src"), new File("lib"));
			
			// ����ָ���ļ���ָ��Ŀ¼��
			FileUtils.copyFileToDirectory(new File("hello.txt"), new File("src"));
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
	/**
	 * �г�Ŀ¼�������������ļ�
	 */
	public static void listFile() {
		/*
		// �ҳ��ļ������ļ����ݲ�Ϊ�յ��ļ�
		Collection<File> files = FileUtils.listFiles(
				new File("E:/tomcat_7_0"), 
				EmptyFileFilter.NOT_EMPTY, 
				DirectoryFileFilter.INSTANCE
		);
		*/
		
		/*
		// �ҳ�ָ��Ŀ¼�У��ļ�����.png����.gif��β�ļ�
		Collection<File> files = FileUtils.listFiles(
				new File("E:/tomcat_7_0"), 
				FileFilterUtils.or(new SuffixFileFilter(".gif"), new SuffixFileFilter(".png")),
				DirectoryFileFilter.INSTANCE
		);
		*/
		// �ҳ�ָ��Ŀ¼·���ļ�����tomcat��ͷ��������.gif��β�ļ�
		Collection<File> files = FileUtils.listFiles(
				new File("E:/tomcat_7_0"), 
				FileFilterUtils.and(new PrefixFileFilter("tomcat"), new SuffixFileFilter(".gif")),
				DirectoryFileFilter.INSTANCE
		);
		
		for (File file : files) {
			System.out.println(file.getAbsolutePath());
		}
	}
}

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
	 * 获取文件或者目录的大小，单位，字节
	 */
	public static void getSize() {
		long size = FileUtils.sizeOf(new File("E:/"));
		System.out.println(size);  // byte
	}
	
	/**
	 * 读取文件内容
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
	 * 将数据写入文件
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
	 * 拷贝文件或者目录
	 */
	public static void copyFileOrDirctory() {
		try {
			//FileUtils.copyFile(new File("hello.txt"), new File("hello_copy.txt"));
			
			// 拷贝复制已有目录
			// FileUtils.copyDirectory(new File("src"), new File("src_bak"));
			
			// 将目录拷贝到其他目录中
			// FileUtils.copyDirectoryToDirectory(new File("src"), new File("lib"));
			
			// 拷贝指定文件到指定目录中
			FileUtils.copyFileToDirectory(new File("hello.txt"), new File("src"));
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
	/**
	 * 列出目录下满足条件的文件
	 */
	public static void listFile() {
		/*
		// 找出文件夹中文件内容不为空的文件
		Collection<File> files = FileUtils.listFiles(
				new File("E:/tomcat_7_0"), 
				EmptyFileFilter.NOT_EMPTY, 
				DirectoryFileFilter.INSTANCE
		);
		*/
		
		/*
		// 找出指定目录中，文件名以.png或者.gif结尾文件
		Collection<File> files = FileUtils.listFiles(
				new File("E:/tomcat_7_0"), 
				FileFilterUtils.or(new SuffixFileFilter(".gif"), new SuffixFileFilter(".png")),
				DirectoryFileFilter.INSTANCE
		);
		*/
		// 找出指定目录路，文件名以tomcat开头，并且以.gif结尾文件
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

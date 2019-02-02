package lixin.gan;

import java.util.Arrays;

public class UseArray {
	public static void main(String[] args) {
		useArrays();
	}
	
	public static void testCopy() {
		int[] arr1 = new int[5];
		int[] arr2 = new int[10];
		
		for (int i = 0; i < 5; i++) {
			arr1[i] = i * 2;
		}
		
		System.arraycopy(arr1, 2, arr2, 6, 2);
		
		for (int i = 0; i < arr2.length; i++) {
			System.out.print(arr2[i] + " ");
		}
	}
	
	public static int removeElement(int[] arr, int index) {
		if (index < -1 || index >= arr.length) {
			throw new ArrayIndexOutOfBoundsException();
		}
		int deleteVal = arr[index];
		System.arraycopy(arr, index + 1, arr, index, arr.length - index - 1);
		arr[arr.length-1] = 0; 
		return deleteVal;
	}
	
	public static void useArrays() {
		int[] arr = {4,1,3,6,2};
		System.out.println(Arrays.toString(arr)); // [4, 1, 3, 6, 2]
		
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr)); // [1, 2, 3, 4, 6]
		
		Student[] stu = {
				new Student(5, "aaa"),
				new Student(1, "bbb"),
				new Student(9, "ccc")
		};
		Arrays.sort(stu);
		System.out.println(Arrays.toString(stu));
		
		// 在已经排序的数组中查找 index为-1时，表示未找到
		int index = Arrays.binarySearch(arr, 2);
		System.out.println(index);
	}
	
}

// 要想进行排序，需要实现Comparable接口
class Student implements Comparable {
	private int id;
	private String name;
	public Student(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	@Override
	public int compareTo(Object obj) {
		Student stu = (Student) obj;
		if (this.id < stu.id) {
			return -1;
		} else if (this.id > stu.id) {
			return 1;
		}
		return 0;
	}
	
	@Override
	public String toString() {
		return this.id + " " + this.name;
	}
}
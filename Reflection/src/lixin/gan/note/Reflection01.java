package lixin.gan.note;

public class Reflection01 {
	public static void main(String[] args) {
		
/*
 * 我们以前在使用new关键字来创建对象的时候，JVM会首先将该class加载，保存的是一个模子，
 * 之后使用new关键字来创建的对象保证都是一样的。这个模子保存了class的所有信息（结构和属性）
 * 
 * 但是有时候，我们在工作中，需要实例化的类有时候是未知的（不同的情况需要实例化不同的类）
 * 此时，我们希望能动态的传入类的名字，然后在实例化这个类，而不是将类名写死
 * 
 * 一个类只对应一个Class对象（也可以说成一个类型对应一个class对象）
 */
		
		try {
			String path = "lixin.gan.orm.annotation.Person";
			Class clas1 = Class.forName(path);
			Class clas2 = Class.forName(path);
			System.out.println(clas1.hashCode() == clas2.hashCode()); // true
			// 说明上面的两个类是一个Class对象
			
			// 注意，类型相同，则对应的Class对象相同，对于数组而言，与数组的元素类型和维数相关，与长度无关
			int[] a1 = new int[10];
			int[] a2 = new int[20];
			int[][] a3 = new int[10][20];
			System.out.println(a1.getClass().hashCode() == a2.getClass().hashCode());  // true
			System.out.println(a1.getClass().hashCode() == a3.getClass().hashCode());  // false
			
			double[] d4 = new double[10];
			System.out.println(d4.getClass().hashCode() == a1.getClass().hashCode());  // false
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
}

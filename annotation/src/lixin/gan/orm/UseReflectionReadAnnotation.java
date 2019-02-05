package lixin.gan.orm;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

import lixin.gan.orm.annotation.MyField;
import lixin.gan.orm.annotation.MyTable;

/**
 * 利用反射来读取注解
 * @author 13550
 *
 */
public class UseReflectionReadAnnotation {
	public static void main(String[] args) {
		try {
			Class clas = Class.forName("lixin.gan.orm.Person");
			
			// 获取“类”所有的注解
			Annotation[] annotations = clas.getAnnotations();
			for (Annotation tmp : annotations) {
				System.out.println(tmp);
			}
			// @lixin.gan.orm.annotation.Table(value=Person)
			
			// 因为一个地方，可以使用多个注解，那么，可以通过下面这种方式来查看使用具体某个注解的信息
			
			// 获得该类来说使用某个注解的信息
			MyTable t = (MyTable)clas.getAnnotation(MyTable.class);
			System.out.println(t); // @lixin.gan.orm.annotation.Table(value=Person)
			System.out.println(t.value()); // Person
			
			// 获得类的属性的注解
			Field f = clas.getDeclaredField("name"); // 获取字段
			MyField myField = f.getAnnotation(MyField.class);
			System.out.println(myField.columnName() + " -- " + myField.type() + " -- " + myField.length() + " -- " + myField.canEmpty());
			// name -- varchar -- 30 -- true
			
			/**
			 * 此时可以根据上面的信息，拼接sql来创建表
			 */
			
		} catch (ClassNotFoundException | NoSuchFieldException | SecurityException e) {
			e.printStackTrace();
		}
		
	}
}

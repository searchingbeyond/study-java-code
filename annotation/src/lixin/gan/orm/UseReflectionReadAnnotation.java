package lixin.gan.orm;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

import lixin.gan.orm.annotation.MyField;
import lixin.gan.orm.annotation.MyTable;

/**
 * ���÷�������ȡע��
 * @author 13550
 *
 */
public class UseReflectionReadAnnotation {
	public static void main(String[] args) {
		try {
			Class clas = Class.forName("lixin.gan.orm.Person");
			
			// ��ȡ���ࡱ���е�ע��
			Annotation[] annotations = clas.getAnnotations();
			for (Annotation tmp : annotations) {
				System.out.println(tmp);
			}
			// @lixin.gan.orm.annotation.Table(value=Person)
			
			// ��Ϊһ���ط�������ʹ�ö��ע�⣬��ô������ͨ���������ַ�ʽ���鿴ʹ�þ���ĳ��ע�����Ϣ
			
			// ��ø�����˵ʹ��ĳ��ע�����Ϣ
			MyTable t = (MyTable)clas.getAnnotation(MyTable.class);
			System.out.println(t); // @lixin.gan.orm.annotation.Table(value=Person)
			System.out.println(t.value()); // Person
			
			// ���������Ե�ע��
			Field f = clas.getDeclaredField("name"); // ��ȡ�ֶ�
			MyField myField = f.getAnnotation(MyField.class);
			System.out.println(myField.columnName() + " -- " + myField.type() + " -- " + myField.length() + " -- " + myField.canEmpty());
			// name -- varchar -- 30 -- true
			
			/**
			 * ��ʱ���Ը����������Ϣ��ƴ��sql��������
			 */
			
		} catch (ClassNotFoundException | NoSuchFieldException | SecurityException e) {
			e.printStackTrace();
		}
		
	}
}

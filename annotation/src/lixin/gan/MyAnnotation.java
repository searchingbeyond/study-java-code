package lixin.gan;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*
 * @Target(value={....})��ָ����ע���������Щ�ط�ʹ��
 */
@Target(value= {
		ElementType.METHOD, // ������
		ElementType.TYPE, // ���ʹ�������class��interface
		ElementType.FIELD, // �����ֶδ�
		ElementType.PACKAGE, // ������
		ElementType.PARAMETER  // �����ĵط�
})

/*
 * @Retention() ������ע��ᱣ��������
 */
//@Retention(RetentionPolicy.CLASS)  ��ע��ᱣ����class�ļ���
//@Retention(RetentionPolicy.SOURCE)  ��ע��ᱣ����Դ������
// ���������ע�⣬������Ա������ɼ��ģ�����������ʱ��ע���ʧЧ��
@Retention(RetentionPolicy.RUNTIME)   // ע�Ᵽ��������ʱ�����Ա�֤��������������
public @interface MyAnnotation {
	/*
	 **�Զ����ע�⣬��ʽ����
	 */
	
	/**
	 * ����ע��Ĳ���ֵ�� ������Ĭ��ֵ��û��Ĭ��ֵʱ��ʹ�ø�ע�⣬�����ṩֵ��
	 */
	String name() default ""; // ��ʾһ����Ϊname�ġ����ԡ���������String
	
	int age() default 0;  // ��ʾһ����Ϊage�ġ����ԡ��� ������int�� Ĭ��ֵ��0
	
	String[] hobby() default {"basketball", "swimming"};  // ������String[]
	
	String value();  
	// ����value��˵�Ƚ��ر����һ��ע���У�ֻ��valueû��Ĭ��ֵ����ô����ʡ��value��ֱ��дֵ
	/*
	@MyAnnotation(value="hello")  �ȼ��� @MyAnnotation("hello")
	 * 
	 */
}

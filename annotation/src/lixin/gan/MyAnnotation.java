package lixin.gan;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*
 * @Target(value={....})是指，该注解可以在哪些地方使用
 */
@Target(value= {
		ElementType.METHOD, // 方法处
		ElementType.TYPE, // 类型处，比如class、interface
		ElementType.FIELD, // 属性字段处
		ElementType.PACKAGE, // 包名处
		ElementType.PARAMETER  // 参数的地方
})

/*
 * @Retention() 表明该注解会保留在哪里
 */
//@Retention(RetentionPolicy.CLASS)  该注解会保留在class文件中
//@Retention(RetentionPolicy.SOURCE)  该注解会保留在源代码中
// 上面的两种注解，都是针对编译器可见的，但是在运行时，注解就失效了
@Retention(RetentionPolicy.RUNTIME)   // 注解保留到运行时，可以保证被其他类来解析
public @interface MyAnnotation {
	/*
	 **自定义的注解，格式如上
	 */
	
	/**
	 * 定义注解的参数值， 可以有默认值；没有默认值时，使用该注解，必须提供值。
	 */
	String name() default ""; // 表示一个名为name的“属性”，类型是String
	
	int age() default 0;  // 表示一个名为age的“属性”， 类型是int， 默认值是0
	
	String[] hobby() default {"basketball", "swimming"};  // 类型是String[]
	
	String value();  
	// 对于value来说比较特别，如果一个注解中，只有value没有默认值，那么可以省略value，直接写值
	/*
	@MyAnnotation(value="hello")  等价于 @MyAnnotation("hello")
	 * 
	 */
}

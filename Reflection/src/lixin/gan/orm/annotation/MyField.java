package lixin.gan.orm.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value= {ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyField {
	String columnName();
	String type();
	int length();
	boolean canEmpty() default true;
	boolean primaryKey() default false;
}

package lixin.gan.orm.annotation;

@MyTable("Person")  // µÈ¼ÛÓÚ@Table(value= "Person")
public class Person {

	@MyField(columnName="id", type="int", length=10, primaryKey=true)
	private int id;
	
	@MyField(columnName="name", type="varchar", length=30)
	private String name;
	
	@MyField(columnName="gender", type="String", length=3)
	private String gender;

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", gender=" + gender + "]";
	}
}

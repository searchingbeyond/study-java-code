package lixin.gan.orm.annotation;

@MyTable("person")  // µÈ¼ÛÓÚ@Table(value= "Person")
@MyAnnotation2("hehe")
public class Person {

	@MyField(columnName="id", type="int", length=10, primaryKey=true)
	private int id;
	
	@MyField(columnName="name", type="varchar", length=30)
	private String name;
	
	@MyField(columnName="gender", type="String", length=3)
	private String gender;

	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Person(int id, String name, String gender) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", gender=" + gender + "]";
	}
}

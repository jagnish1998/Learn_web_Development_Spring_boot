package learn.springboot.udemy.second;

public class Course {
	private int id;
	private String name;
	private int fee;
	
	
	
	public Course(int id, String name, int fee) {
		super();
		this.id = id;
		this.name = name;
		this.fee = fee;
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public int getFee() {
		return fee;
	}
	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", fee=" + fee + "]";
	}
	
	
	
}

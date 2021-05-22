package studentSystem;

import java.util.Objects;

public class Course {
	private int code;
	private String instructor;
	private String name;


	public Course(int code, String name, String instructor) {
		this.setCode(code);
		this.setName(name);
		this.setInstructor(instructor);
	}

	public Course(Course c) {
		this(c.code, c.name, c.instructor);
	}

	public int getCode() {
		return this.code;
	}

	public void setCode(int code) {
		this.code = code;
	}
	
	public String getInstructor() {
		return this.instructor;
	}

	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.code + this.instructor + this.name);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Course) {
			Course other = (Course) obj;
			return (this.hashCode() == other.hashCode());
		} else {
			return false;
		}
	}
}

package Assignment8;

public class Student implements Comparable{
	private String id;
	private String name;
	private String gender;
	
	public Student(String id, String name, String gender) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
	}
	
	public String getId() {
		return this.id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return this.gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public String toString() {
		return "[Name,Id] = [" + getName() + "," + getId() + "]";
	}

	public int hashCode() {
		return this.getId().hashCode();
	}

	public boolean equals(Object o) {
		Student s = (Student) o;
		return s.getId().equals(this.getId());
	}

	public int compareTo(Object o) {
		Student s = (Student) o;
		return this.getName().compareTo(s.getName());
		// return this.getId().compareTo(s.getId());
	}

}

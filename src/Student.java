
public class Student implements Comparable<Student>{
	private int score;
	private String name;
	
	
	public Student(int score, String name) {
		super();
		this.score = score;
		this.name = name;
	}


	@Override
	public int compareTo(Student o) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public String toString() {
		return name + " " + score;
	}
	
	
}

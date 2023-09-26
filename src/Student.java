
public class Student implements Comparable<Student>{
	private int score;
	private String name;
	
	
	public Student(int score, String name) {
		super();
		this.score = score;
		this.name = name;
	}


	@Override
	public int compareTo(Student otherStudent) {
		
		return Integer.compare(this.score, otherStudent.getScore());
	}


	@Override
	public String toString() {
		return name + " " + score;
	}
	
	public int getScore() {
		return this.score;
	}
	public String getName() {
		return this.name;
	}
	
	
}

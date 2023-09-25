
public class Student implements Comparable<Student>{
	private int score;
	private String name;
	
	
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

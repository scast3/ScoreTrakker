/*
 * Class: Student
 * Student class used by ScoreTrakker holds name and score of each 
 * student. compareTo() method sorts by score.
 * Authors: Andrew Balmaseda and Santiago Castillo
 * Date: 9/22/2023
 * Collaborators: N/A
 * Sources: JavaTPoint for Comparable interface
 */

public class Student implements Comparable<Student>{
	private int score;
	private String name;
	
	
	public Student(int score, String name) {
		super();
		this.score = score;
		this.name = name;
	}


	@Override
	//Compares the scores of the students
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

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class ScoreTrakker {
	private ArrayList<Student> students;
	private String[] files = {"scores.txt", "badscore.txt", "nofile.txt" };
	
	public ScoreTrakker() {
		super();
		students = new ArrayList<Student>();
	}
	
	public void loadDataFile(String filename) {
		try {
			FileReader reader = new FileReader(filename);
			Scanner in = new Scanner(reader);
			
			while (in.hasNextLine()) {
				String tempName;
				String tempScore;
				
				tempName = in.nextLine();
				tempScore = in.nextLine();
				try {
					Student currentStudent = new Student(Integer.parseInt(tempScore), tempName);
					students.add(currentStudent);
				} catch (NumberFormatException e) {
					System.out.println();
					System.out.println("Incorrect format for " + tempName + " not a valid score: " + tempScore);
					System.out.println();
				}
			}
			
			in.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("Can't open file: "+filename);
		}
	}


	public void printInOrder() {
		
		//sort by student name
		Collections.sort(students, new Comparator<Student>(){
			public int compare(Student studentA, Student studentB) {
				System.out.println(studentA.getScore() - studentB.getScore());
				return studentA.getScore() - studentB.getScore();
			}
		});
		
		for(Student s : students) {
			System.out.println(s);
		}
	}
	
	public void processFiles() {
		System.out.println("Student Score List");
		loadDataFile("scores.txt");
		printInOrder();
	}
	public static void main(String[] args) {
		ScoreTrakker test = new ScoreTrakker();
		test.processFiles();
	}
}

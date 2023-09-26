import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class ScoreTrakker {
	private ArrayList<Student> students;
	
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
					System.out.println("Incorrect format for " + tempName + " not a valid score: " + tempScore);
				}
			}
			
			in.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("Can't open file: "+filename);
		}
	}


	public void printInOrder() {
		System.out.println("Student Score List");
		//sort by student name
		for(Student s : students) {
			System.out.println(s);
		}
	}
	
	public void processFiles() {
		loadDataFile("scores.txt");
		printInOrder();
	}
	public static void main(String[] args) {
		ScoreTrakker test = new ScoreTrakker();
		test.processFiles();
	}
}

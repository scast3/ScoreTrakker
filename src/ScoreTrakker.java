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
	
	public void loadDataFile(String filename) throws FileNotFoundException {
		try {
			// Open a file to read
			FileReader reader = new FileReader(filename);
			// Initialize scanner to read file
			Scanner in = new Scanner(reader);
			// Loop until the end of file
			while (in.hasNextLine()) {
				String tempName;
				String tempScore;
				
				tempName = in.nextLine();
				tempScore = in.nextLine();
				// Try to add the next student to list of students and throw an exception if invalid.
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
		}
			catch(FileNotFoundException e) {
				throw e;
			}
		
			
		
	}


	public void printInOrder() {
		
		//sort by student score by calling the compareTo method in the Student class
		Collections.sort(students);
		
		// Prints the sorted list of students
		for(Student s : students) {
			System.out.println(s);
		}
	}
	
	public void processFiles() {
		System.out.println("Student Score List");
		for(String fileName:files) {
			try {
				loadDataFile(fileName);
				printInOrder();
				students.clear();
			} catch (FileNotFoundException e) {
				System.out.println("\nCan't open file: "+fileName);
			}}
		
		
	}
	public static void main(String[] args) {
		ScoreTrakker test = new ScoreTrakker();
		test.processFiles();
	}
}

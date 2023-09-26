/*
 * Class: ScoreTrakker
 * Loads in data files to read off the name and score. Prints the lists
 * in order of score and handles exceptions of an incorrect input and
 * inaccessible data files.
 * Authors: Andrew Balmaseda and Santiago Castillo
 * Date: 9/22/2023
 * Collaborators: N/A
 * Sources: JavaTPoint for Comparable interface
 */

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
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
		// Throws an exception to be caught by processFiles
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
		// Iterates through the list of files
		for(String fileName:files) {
			// Catches FileNotFoundException thrown in the loadDataFile() method
			try {
				loadDataFile(fileName);
				printInOrder();
				students.clear(); // Clears the arrayList after every iteration
			} catch (FileNotFoundException e) {
				System.out.println("\nCan't open file: "+fileName);
			}}
		
		
	}
	public static void main(String[] args) {
		ScoreTrakker test = new ScoreTrakker();
		test.processFiles();
	}
}

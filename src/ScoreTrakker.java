import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

public class ScoreTrakker {
	private ArrayList<Student> students;
	
	
	public void loadDataFile(String filename) {
		try {
			int line = 1;
			FileReader reader = new FileReader(filename);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void printInOrder() {
		for(Student s : students) {
			System.out.println(s);
		}
	}
	
	public void processFiles() {
		loadDataFile("scores.txt");
		printInOrder();
	}
	public static void main(String[] args) {
		
	}
}

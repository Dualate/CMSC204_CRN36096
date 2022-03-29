import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * @author Camron Franklin CMSC204 CRN 36096
 *
 */
public class CourseDBManager implements CourseDBManagerInterface {

	CourseDBStructure schedule;
	
	/**
	 * Default no-args constructor
	 */
	public CourseDBManager() {
		schedule = new CourseDBStructure(10);
	}
	
	/**
	 * Adds a course (CourseDBElement) with the given information
	 * to CourseDBStructure.
	 * @param id course id 
	 * @param crn course crn
	 * @param credits number of credits
	 * @param roomNum course room number
	 * @param instructor name of the instructor
	 */
	@Override
	public void add(String id, int crn, int credits, String roomNum, String instructor) {
		CourseDBElement course = new CourseDBElement(id, crn, credits, roomNum, instructor);
		schedule.add(course);
	}

	/**
	 * finds  CourseDBElement based on the crn key
	 * @param crn course crn (key)
	 * @return a CourseDBElement object
	 * 
	 */
	@Override
	public CourseDBElement get(int crn) {
		CourseDBElement course = null;
		try {
			course = schedule.get(crn);
		} catch (IOException e) {
			System.out.println("Course not found");
		}
		return course;
	}

	/**
	 * Reads the information of courses from a test file and adds them
	 * to the CourseDBStructure data structure
	 * @param input input file 
	 * @throws FileNotFoundException if file does not exists
	 */
	@Override
	public void readFile(File input) throws FileNotFoundException {
		Scanner tr;
		try{
			tr =  new Scanner(input);
		} catch (FileNotFoundException e) {
			throw new FileNotFoundException();
		}
		tr.useDelimiter("\n");
		while(tr.hasNext()) {
		String[] line = tr.next().split(" ");
		String name = line[0];
		int crn = Integer.parseInt(line[1]);
		int credits = Integer.parseInt(line[2]);
		String room = line[3];
		String instructor = "";
		for (int i = 4; i < line.length; i++)
			instructor += line[i] + " ";
		CourseDBElement course = new CourseDBElement(name, crn, credits, room, instructor);
		schedule.add(course);
		}
	}

	/**
	* Returns the size of the ConcordanceDataStructure (number of indexes in the array)
	*/
	@Override
	public ArrayList<String> showAll() {
		return schedule.showAll();
	}

}

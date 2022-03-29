import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * 
 * @author Camron Franklin CMSC204 CRN 36096
 *
 */
public class CourseDBStructure implements CourseDBStructureInterface {
	
	LinkedList[] bucket;
	
	/**
	 * Testing constructor
	 * @param name testing field
	 * @param size size of the array
	 */
	public CourseDBStructure(String name, int size) {

		bucket = new LinkedList[size];

	}
	
	/**
	 * Constructor the initializes the size of the array
	 * @param size size of array
	 */
	public CourseDBStructure(int size) {

		bucket = new LinkedList[size];

	}
	
	/** 
	* Adds a CourseDBElement object to the CourseDBStructure using the hashcode
	* of the CourseDatabaseElemen object's crn value.
	* If the CourseDatabaseElement already exists, exit quietly
	*  
	* @param element the CourseDBElement to be added to CourseDBStructure
	*/
	public void add(CourseDBElement element) {
		int index = Integer.toString(element.getCRN()).hashCode();
		index %= bucket.length;
		if (bucket[index] == null) {
			bucket[index] = new LinkedList<CourseDBElement>();
			bucket[index].add(element);
		} else {
			Iterator<CourseDBElement> itr = bucket[index].iterator();
			while(itr.hasNext()) {
				CourseDBElement target = itr.next();
				if(target.getCRN() == element.getCRN()) {
					bucket[index].remove(target);
					break;
				}
			}
			bucket[index].add(element);
		}

	}

	/**
	 * Find a courseDatabaseElement based on the key (crn) of the
	 * courseDatabaseElement If the CourseDatabaseElement is found return it If not,
	 * throw an IOException
	 * 
	 * @param crn crn (key) whose associated courseDatabaseElement is to be returned
	 * @return a CourseDBElement whose crn is mapped to the key
	 * @throws IOException if key is not found
	 */
	@Override
	public CourseDBElement get(int crn) throws IOException {
		CourseDBElement target = null;
		int index = Integer.toString(crn).hashCode() % bucket.length;
		if (!(bucket[index] == null)) {
			Iterator<CourseDBElement> itr = bucket[index].iterator();
			
			while(itr.hasNext()) {
				target = itr.next();
				if(target.getCRN() == crn)
					return target;
			}
		}
		throw new IOException();
	}

	/**
	 * @return an array list of string representation of each course in 
	 * the data structure separated by a new line. 
	 * Refer to the following example:
	 * Course:CMSC500 CRN:39999 Credits:4 Instructor:Nobody InParticular Room:SC100
	 * Course:CMSC600 CRN:4000 Credits:4 Instructor:Somebody Room:SC200
	 */
	@Override
	public ArrayList<String> showAll() {
		ArrayList<String> list = new ArrayList<String>();
		
		for (int i = 0; i < bucket.length; i++) {
			if(bucket[i] == null)
				continue;
			LinkedList<CourseDBElement> current = bucket[i];
			Iterator<CourseDBElement> itr = current.iterator();
			while(itr.hasNext()) {
				CourseDBElement course = itr.next();
				String result = "Course:" + course.getID() + 
								" CRN:" + Integer.toString(course.getCRN()) + 
								" Credits:" + Integer.toString(course.getCredits()) + 
								" Room:"	+ course.getRoomNum() + 
								" Instructor:" + course.getInstructorName();
				list.add(result);
			}
		}
		
		return list;
	}

	/**
	* Returns the size of the ConcordanceDataStructure (number of indexes in the array)
	*/
	@Override
	public int getTableSize() {
		return bucket.length;
	}

}

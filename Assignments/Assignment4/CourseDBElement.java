/**
 * 
 * @author Camron Franklin CMSC204 CRN 36096
 *
 */
public class CourseDBElement implements Comparable {


	String courseID;
	int crn;
	int credits;
	String roomNumber;
	String instructorName;
	
	/**
	 * default no-args constructor
	 */
	public CourseDBElement() {
		courseID = null;
		crn = 0;
		credits = 0;
		roomNumber = null;
		instructorName = null;
	}
	
	/**
	 * constructor that initializes class fields
	 * @param name name of the course
	 * @param crn CRN code for the course
	 * @param credits number of credits for the course
	 * @param roomNum room number for the course
	 * @param professor instructor of the course
	 */
	public CourseDBElement(String name, int crn, int credits, String roomNum, String professor) {
		this.courseID = name;
		this.crn = crn;
		this.credits = credits;
		this.roomNumber = roomNum;
		this.instructorName = professor;
	}
	
	/**
	 * returns name of the course
	 * @return name of the course
	 */
	public String getID() {
		return courseID;
	}

	/**
	 * Sets the name of the course
	 * @param courseID name of the course
	 */
	public void setID(String courseID) {
		this.courseID = courseID;
	}

	/**
	 * Returns CRN
	 * @return CRN
	 */
	public int getCRN() {
		return crn;
	}

	/**
	 * Sets the course CRN
	 * @param crn crn of the course
	 */
	public void setCRN(int crn) {
		this.crn = crn;
	}

	/**
	 * Returns number of credits for the course
	 * @return credits for the course
	 */
	public int getCredits() {
		return credits;
	}

	/**
	 * Sets the number of credits for the course
	 * @param credits number of credits for the course
	 */
	public void setCredits(int credits) {
		this.credits = credits;
	}

	/**
	 * Returns room number for the course
	 * @return room number of the course
	 */
	public String getRoomNum() {
		return roomNumber;
	}

	/**
	 * Sets the room number of the course
	 * @param roomNumber room number of the course
	 */
	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}

	/**
	 * Returns the instructor's name
	 * @return name of the instructor
	 */
	public String getInstructorName() {
		return instructorName;
	}

	/**
	 * Sets the name of the instructor
	 * @param instructorName name of the instructor
	 */
	public void setInstructorName(String instructorName) {
		this.instructorName = instructorName;
	}

	/**
	 * Compares two CourseDBElements
	 * @param o CourseDBElement to be compared
	 * @return 1 if the two objects match, 0 if they don't
	 */
	@Override
	public int compareTo(Object o) {
		CourseDBElement course = (CourseDBElement) o;
		if(course.getCRN() == this.crn) {
			if (course.getID() == this.courseID) {
				if(course.getCredits() == this.credits) {
					if(course.getRoomNum() == this.roomNumber) {
						if(course.getInstructorName() == this.instructorName)
							return 1;
					}
				}
			}
		}
		return 0;
	}

}

import java.util.ArrayList;

/**
 * 
 * @author Camron Franklin CMSC204 CRN 36096
 *
 */
public class Town implements Comparable<Town> {
	String name;
	ArrayList<Town> adj;
	
	/**
	 * Constructor assigns name of town
	 * @param name name of town
	 */
	public Town(String name) {
		this.name = name;
		adj = new ArrayList<Town>();
	}
	 /**
	  * Returns name of the town
	  * @return name of town
	  */
	
	public Town(Town t) {
		this.name = t.getName();
	}
	
	public String getName() {
		return name;
	}

	/**
	 * Compares two town objects to one another, returns int based on result
	 * @param o town to be compared
	 * @return -1 if towns are not equal, 0 otherwise
	 */
	public int compareTo(Town o) {
		
		if(o.getName().equals(this.name))
			return 0;
		return -1;
	}
	
	/**
	 * Determines equality of two town objects
	 * @param o town to be compared
	 * @return true if they are equal, false otherwise
	 */
	@Override
	public boolean equals(Object o) {
		if (this.name.equals(((Town) o).getName()))
			return true;
		return false;
	}
	
	public int hashCode() {		
		return name.hashCode();
	}

	public String toString() {
		return this.name;
	}
	
	/**
	 * Adds towns to adjacency list
	 * @param o adjacent town to be added to list
	 */
	public void addAdjacent(Town o) {
		adj.add(o);
	}
	
}

/**
 * 
 * @author Camron Franklin CMSC204 CRN 36096
 *
 */
public class Road implements Comparable<Road>{

	String name;
	Town source;
	Town destination;
	int weight;
	
	public Road(Town source, Town destination, int weight, String name) {
		this.source = source;
		this.destination = destination;
		this.weight = weight;
		this.name = name;
	}
	
	public Road(Town source, Town destination, String name) {
		this.source = source;
		this.destination = destination;
		this.name = name;
		weight = 1;
	}
	
	/**
	 * Returns name of road
	 * @return name of road
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Returns town at one end of the road
	 * @return source vertex
	 */
	public Town getSource() {
		return source;
	}
	
	/**
	 * Returns town at other end of the road
	 * @return destination vertex
	 */
	public Town getDestination() {
		return destination;
	}
	
	/**
	 * Returns weight of the road
	 * @return weight of the road
	 */
	public int getWeight() {
		return weight;
	}
	
	
	/**
	 * Compares two roads, returns int of result
	 * @param o road to be compared
	 * @return -1 if they are not the same, 0 otherwise
	 */
	@Override
	public int compareTo(Road o) {
		if(o.getSource().equals(source) || o.getDestination().equals(source)) {
			if (o.getDestination().equals(destination) || o.getSource().equals(destination))
				return 0;
		}
		return -1;
	}
	
	
	/**
	 * Compares two roads, returns if they are equal
	 * @param o road to be compared
	 * @return true if they are equal, false otherwise
	 */
	@Override
	public boolean equals(Object o) {
		return compareTo( (Road) o) == 0 ? true : false;
	}
	
}

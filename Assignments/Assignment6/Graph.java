import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Iterator;
import java.util.Map;
public class Graph implements GraphInterface<Town, Road>{

	Set<Town> towns = new HashSet<Town>();
	Set<Road> roads = new HashSet<Road>();
	ArrayList<String> path = new ArrayList<String>();

	
	public Road getEdge(Town source, Town destination) {
		Road temp = new Road(source, destination, "");
		Iterator<Road> itr = roads.iterator();
		while(itr.hasNext()) {
			Road street = itr.next();
			if (street.compareTo(temp) == 0)
				return street;
		}
		return null;
	}
	
	public Road addEdge(Town source, Town destination, int weight, String name) throws NullPointerException, IllegalArgumentException {
		if(source == null || destination == null)
			throw new NullPointerException();
		if(towns.contains(source) && towns.contains(destination)) {
			Road _new = new Road(source, destination, weight, name);
			roads.add(_new);
			
			source.addAdjacent(destination);
			destination.addAdjacent(source);
		}
		
		return null;
	}
	
	public boolean addVertex(Town t) throws NullPointerException {
		if (t == null)
			throw new NullPointerException();
		Iterator<Town> itr = towns.iterator();
		while(itr.hasNext()) {
			Town city = itr.next();
			if (city.compareTo(t) == 0)
				return false;
		}
		towns.add(t);
		
		return true;
	}
	
	public boolean containsEdge(Town source, Town destination) {
		Iterator<Road> itr = roads.iterator();
		while(itr.hasNext()) {
			Road street = itr.next();
			if (street.getSource().equals(source) || street.getSource().equals(destination)) {
				if (street.getDestination().equals(source) || street.getDestination().equals(destination))
					return true;
			}
		}
		return false;
	}

	@Override
	public boolean containsVertex(Town v) {
		Iterator<Town> itr = towns.iterator();
		while(itr.hasNext()) {
			Town temp = itr.next();
			if (temp.compareTo(v) == 0)
				return true;
		}
		return false;
	}

	@Override
	public Set<Road> edgeSet() {
		return roads;
	}

	@Override
	public Set<Road> edgesOf(Town vertex) throws IllegalArgumentException, NullPointerException {
		if (vertex == null) 
			throw new NullPointerException();
		
		if (!(towns.contains(vertex)))
			throw new IllegalArgumentException();
		
		Set<Road> set = new HashSet<Road>();
		Iterator<Road> itr = roads.iterator();
		
		while(itr.hasNext()) {
		
			Road temp = itr.next();
			if (temp.getSource().equals(vertex) || temp.getDestination().equals(vertex))
				set.add(temp);
		
		}
		return set;
	}

	@Override
	public Road removeEdge(Town sourceVertex, Town destinationVertex, int weight, String description) {
		
		Road target = new Road(sourceVertex, destinationVertex, weight, description);
		Iterator<Road> itr = roads.iterator();
		
		while(itr.hasNext()) {
		
			Road temp = itr.next();
			if (temp.compareTo(target) == 0) {
				roads.remove(temp);
				target = temp;
				break;
			
			}
		}
		return target;
	}

	@Override
	public boolean removeVertex(Town v) {
		
		if (towns.contains(v)) {
		
			towns.remove(v);
			return true;
		
		}
		return false;
	}

	@Override
	public Set<Town> vertexSet() {
		return towns;
	}

	@Override
	public ArrayList<String> shortestPath(Town sourceVertex, Town destinationVertex) {
		
		ArrayList<Town> unvisited = new ArrayList<Town>(towns);
		unvisited.remove(sourceVertex);
		Map<Town, Integer> paths =  new HashMap<Town, Integer>();
		for (Town town: towns) {
			if(!(town.compareTo(sourceVertex) == 0))
				paths.put(town, 1000);
			else
				paths.put(town, 0);
		}
		
		Town current = sourceVertex;
		while(!(unvisited.isEmpty())) {
			for (Road road: edgesOf(current)) {
			}
		}
			
		return this.path;
	}

	@Override
	public void dijkstraShortestPath(Town sourceVertex) {
		// TODO Auto-generated method stub
		
	}
}

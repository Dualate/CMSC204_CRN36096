import java.util.ArrayList;

public class TownGraphManager implements TownGraphManagerInterface{

	Graph graph;
	public TownGraphManager() {
		graph = new Graph();
	}
	
	@Override
	public boolean addRoad(String town1, String town2, int weight, String roadName) {
		if (graph.containsVertex(new Town(town1)) && graph.containsVertex(new Town(town2))) {
			graph.addEdge(new Town(town1), new Town(town2), weight, roadName);
			return true;
		}
		return false;
	}

	@Override
	public String getRoad(String town1, String town2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addTown(String v) {
		return graph.addVertex(new Town(v));
	}

	@Override
	public Town getTown(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean containsTown(String v) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsRoadConnection(String town1, String town2) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<String> allRoads() {
		ArrayList<String> result = new ArrayList<String>();
		for (Road road: graph.edgeSet())
			result.add(road.getName());
		return result;
	}

	@Override
	public boolean deleteRoadConnection(String town1, String town2, String road) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteTown(String v) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<String> allTowns() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<String> getPath(String town1, String town2) {
		// TODO Auto-generated method stub
		return null;
	}

}

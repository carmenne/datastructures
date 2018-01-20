
import java.util.*;

/*
 * SD2x Homework #6
 * This is an implementation of Breadth First Search (BFS) on a graph.
 * You may modify and submit this code if you'd like.
 */

public class BreadthFirstSearch {
	protected Set<Node> marked;
	protected Graph graph;
	protected int edges;

	public BreadthFirstSearch(Graph graphToSearch) {
		marked = new HashSet<Node>();
		graph = graphToSearch;
		edges = 0;
	}
	
	/**
	 * This method was discussed in the lesson
	 */
	public Set<Node> bfs(Node start, String elementToFind) {

		Set<Node> nodes = new HashSet<>();

		if (!graph.containsNode(start)) {
			return Collections.emptySet();
		}
		if (start.getElement().equals(elementToFind)) {
			return Collections.emptySet();
		}
		Queue<Node> toExplore = new LinkedList<Node>();
		marked.add(start);
		toExplore.add(start);
		while (!toExplore.isEmpty()) {
			Node current = toExplore.remove();

			for (Node neighbor : graph.getNodeNeighbors(current)) {

				if (!marked.contains(neighbor)) {

					nodes.add(current);

					if (neighbor.getElement().equals(elementToFind)) {
						return nodes;
					}
					marked.add(neighbor);
					toExplore.add(neighbor);
				}
			}
		}
		return Collections.emptySet();
	}
	

}

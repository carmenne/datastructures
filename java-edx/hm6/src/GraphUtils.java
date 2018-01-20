

import java.util.*;

/*
 * SD2x Homework #6
 * Implement the methods below according to the specification in the assignment description.
 * Please be sure not to change the signature of any of the methods!
 */

public class GraphUtils {

	public static int minDistance(Graph graph, String src, String dest) {

		if (null == src || null == dest || null == graph ||
				!graph.containsElement(src) || !graph.containsElement(dest)) {
			return -1;
		}

		Node srcNode = graph.getNode(src);
		Node destNode = graph.getNode(dest);

		BreadthFirstSearch bfs = new BreadthFirstSearch(graph);
		Set<Node> nodes = bfs.bfs(srcNode, dest);

		if (src == dest) {
			return 0;
		}

		if (nodes.isEmpty()) {
			return -1;
		} else {
			return nodes.size();
		}
	}
	

	public static Set<String> nodesWithinDistance(Graph graph, String src, int distance) {

		if (null == src || null == graph ||
				!graph.containsElement(src) || distance < 1) {
			return null;
		}

		Node srcNode = graph.getNode(src);
		if (!graph.containsElement(src)) {
			return null;
		}

		if (graph.getAllNodes().size() == 1) {
			return Collections.emptySet();
		}


		Set<String> nodes = new HashSet<>();
		Node current = graph.getNode(src);

		Set<Node> marked = new HashSet<>();
		marked.add(srcNode);
		getNeighbors(graph, current, src, distance, nodes, 0, marked);

		return nodes;

	}

	private static void getNeighbors(Graph graph, Node current, String src,
											int distance, Set<String> nodes, int step,
									 	Set<Node> marked) {

		if (step < distance) {
			step++;

			for (Node neighbor : graph.getNodeNeighbors(current)) {
				if (!marked.contains(neighbor)) {

		 			nodes.add(neighbor.getElement());
					marked.add(neighbor);
					}
				getNeighbors(graph, neighbor, src, distance, nodes, step, marked);

			}

		}
	}


	public static boolean isHamiltonianPath(Graph g, List<String> values) {

		if (null == g || null == values || values.isEmpty() || values.size() < 1) {
			return false;
		}

		String src = values.get(0);

		if (!g.containsElement(src)) {
			return false;
		}

		String dst = values.get(values.size() -1);
		if (!(src.equals(dst))) {
			return false;
		}

		List<Node> visited = new ArrayList<>();
		Node prev = g.getNode(src);

		for (int i = 1; i < values.size() - 1; i++) {
			String currentValue = values.get(i);
			Node current = g.getNode(currentValue);
			if (visited.contains(current)) {
				return false;
			} else {
				if (!g.containsElement(currentValue)) {
					return false;
				}

				if (!g.getNodeNeighbors(prev).contains(current)) {
					return false;
				}
				visited.add(current);
				prev = current;
			}
		}

		visited.add(g.getNode(src));
		boolean b = visited.containsAll(g.getAllNodes()) &&
				g.getAllNodes().containsAll(visited);

		return b;
	}
	
}

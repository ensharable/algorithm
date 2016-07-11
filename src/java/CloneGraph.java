package java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Clone an undirected graph. Each node in the graph contains a label and a list
 * of its neighbors.
 * 
 * @author Marcus
 *
 */
public class CloneGraph {
	HashMap<Integer, UndirectedGraphNode> map = new HashMap();

	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		if (node == null) {
			return null;
		}
		if (map.containsKey(node.label)) {
			return map.get(node.label);
		}
		UndirectedGraphNode tempNode = new UndirectedGraphNode(node.label);
		map.put(node.label, tempNode);
		for (UndirectedGraphNode n : node.neighbors) {
			tempNode.neighbors.add(cloneGraph(n));
		}

		return tempNode;
	}

	class UndirectedGraphNode {
		int label;
		List<UndirectedGraphNode> neighbors;

		UndirectedGraphNode(int x) {
			label = x;
			neighbors = new ArrayList<UndirectedGraphNode>();
		}
	};
}

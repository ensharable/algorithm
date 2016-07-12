package java;

import java.util.ArrayList;
import java.util.List;

/**
 * Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each
 * edge is a pair of nodes), write a function to check whether these edges make
 * up a valid tree.
 * 
 * Example Given n = 5 and edges = [[0, 1], [0, 2], [0, 3], [1, 4]], return
 * true.
 * 
 * Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]], return
 * false.
 * 
 * @author Marcus
 *
 */
public class GraphValidTree {

	/**
	 * Use union find algorithm
	 * 
	 * @param n
	 * @param edges
	 * @return
	 */
	public boolean validTree(int n, int[][] edges) {
		// Tree has no cycle and all notes are connected
		int[] parent = new int[n];
		// initilize to "-1"
		for (int i = 0; i < n; i++) {
			parent[i] = -1;
		}

		// to find if there is any cycle
		for (int i = 0; i < edges.length; i++) {
			int u = edges[i][0];
			int v = edges[i][1];
			int uR = findRoot(parent, u);
			int vR = findRoot(parent, v);

			if (uR == vR) {
				// find the cycle
				return false;
			} else {
				union(parent, uR, vR);
			}
		}

		// to see if all graph node visited. which means only have one root(-1)
		int c = 0;
		for (int i = 0; i < n; i++) {
			if (parent[i] == -1) {
				c++;
			}
		}

		return c > 1 ? false : true;
	}

	private int findRoot(int[] parent, int source) {
		if (parent[source] == -1) {
			return source;
		} else {
			return findRoot(parent, parent[source]);
		}
	}

	private void union(int[] parent, int x, int y) {
		int xR = findRoot(parent, x);
		int yR = findRoot(parent, y);
		parent[xR] = yR;
	}
	
	
	/**
	 * Use DFS algorithm
	 * @param n
	 * @param edges
	 * @return
	 */
	public boolean validTree2(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<List<Integer>>(n); //n nodes
        
        // initialize vertices
        for (int i = 0; i < n; i++){
            adj.add(i, new ArrayList<Integer>());
        }
            
        //create adj by the edges
        for(int i=0; i<edges.length; i++){ 
            adj.get(edges[i][0]).add(edges[i][1]); //undirect graph, so need to add two 
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        //initialize visited
        boolean[] visited = new boolean[n];
        
        //start search from node 0, and assume the parent of node 0 is -1
        if(hasCycle(adj, 0, -1, visited)){
            return false;
        }
        
        //check if all nodes visited, if not fully visited, it has isolated note and not a tree
        for(boolean nodevisited:visited){
            if(nodevisited==false){
                return false;
            }
        }
        
        return true;
    }
    
    private boolean hasCycle(List<List<Integer>> adj, int source, int parent, boolean[] visited){
        
        visited[source]=true;
        for(int neighbor: adj.get(source)){
            
            //parent!=neighbor means the parent of the souce is not neighbor
            // Case like A->B B->A consider is ok evern A is visited bofore, because of 
            // undirected graph. other case of visisted before consider cycle exists
            if((visited[neighbor]&&parent!=neighbor) || (!visited[neighbor]&&hasCycle(adj, neighbor, source, visited))){
                return true;
            }
        }
        return false;
    }
}

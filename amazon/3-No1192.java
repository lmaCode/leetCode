class Solution {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<Integer>[] graph = new ArrayList[n];
		for(){
			graph[i] = new ArrayList<>();
		}
		
		for(){
			graph[connection.get(0)].add(connection.get(1));
			graph[connection.get(1)].add(connection.get(0));			
		} //the start and end will be the index
		
		int step;
		List<List<Integer>> res = new ArrayList<>();
		boolean[] visited = new boolean[n];
		int[] timeStamp = new int[n];
		utilMethod(graph, -1, 0, step, visited, res, timeStamp);
		return res;		
    }
	
	public void utilMethod(grap, parent, node, step, visted, res, timeStamp){
		visted[node] = true;
		timeStamp[node] = step;
		int current = timeStamp[node];
		
		for(int neighbor:graph[node]){
			if(neighbor==parent){continue;}
			if(!visited) {utilMethod();}
			timeStamp[node]=Math.min(timeStamp[node],timeStamp[neighbor]);
			if(current<timeStamp[neighbor]){
				res.add(Arrays.asList(node,neighbor));
			}
			
		}
		
	}
}

/*

class Solution {
    // We record the timestamp that we visit each node. For each node, we check every neighbor except its parent and return a smallest timestamp in all its neighbors. If this timestamp is strictly less than the node's timestamp, we know that this node is somehow in a cycle. Otherwise, this edge from the parent to this node is a critical connection
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();
        
        for(List<Integer> oneConnection :connections) {
            graph[oneConnection.get(0)].add(oneConnection.get(1));
            graph[oneConnection.get(1)].add(oneConnection.get(0));
        }
        int timer[] = new int[1];
        List<List<Integer>> results = new ArrayList<>();
        boolean[] visited = new boolean[n];
        int []timeStampAtThatNode = new int[n]; 
        criticalConnectionsUtil(graph, -1, 0, timer, visited, results, timeStampAtThatNode);
        return results;
    }
    
    
    public void criticalConnectionsUtil(List<Integer>[] graph, int parent, int node, int timer[], boolean[] visited, List<List<Integer>> results, int []timeStampAtThatNode) {
        visited[node] = true;
        timeStampAtThatNode[node] = timer[0]++;
        int currentTimeStamp = timeStampAtThatNode[node];
        
        for(int oneNeighbour : graph[node]) {
            if(oneNeighbour == parent) continue;
            if(!visited[oneNeighbour]) criticalConnectionsUtil(graph, node, oneNeighbour, timer, visited, results, timeStampAtThatNode);
            timeStampAtThatNode[node] = Math.min(timeStampAtThatNode[node], timeStampAtThatNode[oneNeighbour]);
            if(currentTimeStamp < timeStampAtThatNode[oneNeighbour]) results.add(Arrays.asList(node, oneNeighbour));
        }
        
        
    }
    
}







class Solution {
   public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
	int[] disc = new int[n], low = new int[n];
	// use adjacency list instead of matrix will save some memory, adjmatrix will cause MLE
	List<Integer>[] graph = new ArrayList[n];
	List<List<Integer>> res = new ArrayList<>();
	Arrays.fill(disc, -1); // use disc to track if visited (disc[i] == -1)
	for (int i = 0; i < n; i++) {
		graph[i] = new ArrayList<>();
	}
	// build graph
	for (int i = 0; i < connections.size(); i++) {
		int from = connections.get(i).get(0), to = connections.get(i).get(1);
		graph[from].add(to);
		graph[to].add(from);
	}

	for (int i = 0; i < n; i++) {
		if (disc[i] == -1) {
			dfs(i, low, disc, graph, res, i);
		}
	}
	return res;
}

int time = 0; // time when discover each vertex

private void dfs(int u, int[] low, int[] disc, List<Integer>[] graph, List<List<Integer>> res, int pre) {
	disc[u] = low[u] = ++time; // discover u
	for (int j = 0; j < graph[u].size(); j++) {
		int v = graph[u].get(j);
		if (v == pre) {
			continue; // if parent vertex, ignore
		}
		if (disc[v] == -1) { // if not discovered
			dfs(v, low, disc, graph, res, u);
			low[u] = Math.min(low[u], low[v]);
			if (low[v] > disc[u]) {
				// u - v is critical, there is no path for v to reach back to u or previous vertices of u
				res.add(Arrays.asList(u, v));
			}
		} else { // if v discovered and is not parent of u, update low[u], cannot use low[v] because u is not subtree of v
			low[u] = Math.min(low[u], disc[v]);
		}
	}
}
}
*/
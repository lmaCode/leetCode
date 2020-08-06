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
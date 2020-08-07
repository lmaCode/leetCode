class Solution {
	//994. Rotting Oranges
	//BFS
    public int orangesRotting(int[][] grid) {
        if(null||0) return 0;
		int rows;
		int cols;
		Queue<int[]> queue = new LinkedList<>();
		int count_fresh;
		for(){
			for(){
				if(){
					queue.offer();
				}else if(){
					count_fresh++;
				}
			}
		}
		if(count_fresh == 0) return 0;
		int count = 0;
		int [][] dirs ={{},{},{},{}};
		while(!queue.isEmpty()){
			++count;
			for(queue.size){
				int[] point = queue.poll();
				for(dir){
					x;y;
					if(<0||==rows||grid[][]==0||2){continue;}
					grid[x][y]=2;
					queue.offer();
					count_fresh--;
				}
			}
		}
		return count_fresh == 0 ? count-1:-1; 
    }
}
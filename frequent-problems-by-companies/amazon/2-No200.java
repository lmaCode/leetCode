//No200 Number of Islands
class Solution {
	
	//DFS--------------------------------------------------------
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0){
			return 0;
		}
		int nr = grid.length;
		int nc = grid[0].length;
		int res = 0;
		for(int r=0;r<nr;r++){
			for(int c=0;c<nc;c++){
				if(grid[r][c]=='1'){
					res++;
					dfs(grid,r,c);//notice
				}
			}
		}
		return res;//notice
    }
	
	void dfs(char[][] grid, int r, int c){//notice
		int nr = grid.length;
		int nc = grid[0].length;
		if(r<0||c<0||r>=nr||c>=nc||grid[r][c]=='0'){//notice
			return;
		}
		grid[r][c]='0';
		dfs(grid, r-1, c);
		dfs(grid, r+1, c);
		dfs(grid, r, c-1);
		dfs(grid, r, c+1);
	}
	
	
	/*
	//BFS--------------------------------------------------------
	public int numIslands(char[][] grid) {
        if(){
			return 0;
		}
		int
		int 
		int res = 0;
		for(){
			for(){
				if(=='1'){
					res++;//
					grid[r][c]=0;//
					Queue<Integer> neighbors = new LinkedList<>();//
					neighbors.add(r*nc+c);//
					while(!neighbors.isEmpty()){
						int id = neighbors.remove();//
						int row = id/nc;
						int col = id%nc;
						if(row-1>=0&&grid[row-1][col]=='1'){//
							neighbors.add((row-1)*nc+col);
							grid[row-1][col]='0';
						}
						if(){//row+1
							
						}
						if(){//col-1
							
						}
						if(){//col+1
							
						}
					}
				}
			}
		}
		return res;
    }
	//Union Find--------------------------------------------------------
	public int numIslands(char[][] grid) {
         if(){
			return 0;
		}
		int
		int 
		int res = 0;
		
		UnionFind uf = new UnionFind();
		for(){
			for(){
				if(){
					grid[r][c] = 0;
					if(r-1>=0&&grid[r-1][c]=='1'){
						uf.union(r*nc+c,(r-1)*nc+c);
					}
					if(){}
					if(){}
					if(){}
				}
			}
		}
		return uf.getCount();
    }
	class UnionFind{
		int count;
		int[] parent;
		int[] rank;
		
		public UnionFind(){
			//init count parent rank
		}
		
		public int find(int i){
			if(parent[i]!=i){
				parent[i] = find(parent[i]);
			}
			return parent[i];
		}
		
		public void union(){
			//Both trees have the same rank – the resulting set’s rank is one larger
			//Both trees have the different ranks – the resulting set’s rank is the larger of the two
		}
		
		public int getCount(){
			//count
		}
	}*/	
	
}
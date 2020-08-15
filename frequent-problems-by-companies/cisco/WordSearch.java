package cisco;
import java.util.Scanner;

public class WordSearch {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public void wordSearch() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		char[][] c = new char[n][n];
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<n; j++) {
				c[i][j]=sc.next().charAt(0);
			}
		}
		int m = sc.nextInt();
		for(int i = 0; i<m-1; i++) {
			System.out.print(exist(c,sc.next())==true?"Yes ":"No ");
		}
		System.out.print(exist(c,sc.next())==true?"Yes":"No");
		sc.close();		
	}
	
	int[][] res ;
    char[] Word;
    public boolean exist(char[][] board, String word) {
        int row = board.length,len = word.length();
        if( len == 0 )
            return true;
        int col = board[0].length;
        if( len > row*col || row == 0 )
            return false;
        Word = word.toCharArray();
        res = new int[row][col];

        for( int i = 0;i<row;i++){
            for( int j = 0;j<col;j++){
                if( Word[0] == board[i][j] ){
                    if(    start(board,i,j,1)    )
                        return true;
                 }
            }
        }
        return false;

    }
    
    public boolean start(char[][] board,int i,int j,int num){
        if( num == Word.length )
            return true;
        res[i][j] = -1;
        char ch = Word[num];
        if( j-1 >= 0 && res[i][j-1] != -1 && ch == board[i][j-1])
            if( start(board,i,j-1,num+1) )
                return true;
        if( j+1 < board[0].length && res[i][j+1] != -1 && ch == board[i][j+1])
            if( start(board,i,j+1,num+1) )
                return true;
        if( i-1 >= 0 && res[i-1][j] != -1 && ch == board[i-1][j] )
            if( start(board,i-1,j,num+1) )
                return true;
        if( i+1 < board.length && res[i+1][j] != -1 && ch == board[i+1][j] )
            if( start(board,i+1,j,num+1))
                return true;
        res[i][j] = 0;
        return false;        
    }
    
}

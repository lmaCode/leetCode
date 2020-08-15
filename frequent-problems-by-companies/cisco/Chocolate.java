package cisco;

public class Chocolate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
new Chocolate().rob(new int[] {1,2,3,1});
	}
	
	//198
	 public int rob(int[] nums) {
		    if (nums.length == 0) return 0;
		    int prev1 = 0;
		    int prev2 = 0;
		    for (int num : nums) {
		        int tmp = prev1;
		        prev1 = Math.max(prev2 + num, prev1);
		        prev2 = tmp;
		    }
		    return prev1;
	 }
}




//Greedy O(N)  O(1) Pick the locally optimal move at each step, and that will lead to the globally optimal solution.
class Solution {
  public int maxSubArray(int[] nums) {
    int n = nums.length;
    int currSum = nums[0], maxSum = nums[0];

    for(int i = 1; i < n; ++i) {
      currSum = Math.max(nums[i], currSum + nums[i]);//never store previous choices
      maxSum = Math.max(maxSum, currSum);
    }
    return maxSum;
  }
}
//???Difference

// Dynamic Programming (Kadane's algorithm)
/*
class Solution {
  public int maxSubArray(int[] nums) {
    int n = nums.length, maxSum = nums[0];
    for(int i = 1; i < n; ++i) {
      if (nums[i - 1] > 0) nums[i] += nums[i - 1];
      maxSum = Math.max(nums[i], maxSum);
    }
    return maxSum;
  }
}
*/

//Divide and Conquer O(Nlog⁡N) O(log⁡N) 
/*
class Solution {
  public int crossSum(int[] nums, int left, int right, int p) {
    if (left == right) return nums[left];

    int leftSubsum = Integer.MIN_VALUE;
    int currSum = 0;
    for(int i = p; i > left - 1; --i) {
      currSum += nums[i];
      leftSubsum = Math.max(leftSubsum, currSum);
    }

    int rightSubsum = Integer.MIN_VALUE;
    currSum = 0;
    for(int i = p + 1; i < right + 1; ++i) {
      currSum += nums[i];
      rightSubsum = Math.max(rightSubsum, currSum);
    }

    return leftSubsum + rightSubsum;
  }

  public int helper(int[] nums, int left, int right) {
    if (left == right) return nums[left];

    int p = (left + right) / 2;

    int leftSum = helper(nums, left, p);
    int rightSum = helper(nums, p + 1, right);
    int crossSum = crossSum(nums, left, right, p);

    return Math.max(Math.max(leftSum, rightSum), crossSum);
  }

  public int maxSubArray(int[] nums) {
    return helper(nums, 0, nums.length - 1);
  }
}
*/

/*----------WRONG ANSWER
class Solution {
    public int maxSubArray(int[] A) {
        int res = 0;
        int tmp = 0;
        for (int i = 0; i<A.length; i++){
            if(A[i]<0){
                res = Math.max(tmp,res);
                tmp = 0;                
            }else{
                tmp+=A[i];                
            }
        }        
        return res;
    }
}
*/
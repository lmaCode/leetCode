class Solution {
	//Two Sum
	//One-pass Hash Table TC O(n) SC O(n)
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(target - nums[i])){
                return new int[]{map.get(target - nums[i]),i};//！
            }
            map.put(nums[i],i);
        }
        return new int[2];//！
    }
}
// brute force O(n^2)
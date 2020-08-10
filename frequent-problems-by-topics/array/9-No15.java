class Solution {//O(n^2)  O(log⁡n)to O(n)
	//details!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i<nums.length&&nums[i]<=0; i++){//nums
            if(i==0 || nums[i]!=nums[i-1]){//=
                twoSum(nums,i,res);
            }
        }
        return res;
        
    }
    public void twoSum(int[] nums, int i, List<List<Integer>> res){
        int lo = i + 1, hi = nums.length -1;
        while(lo<hi){
            int sum = nums[i] + nums[lo] + nums[hi];
            if(sum>0){
                hi--;
            }else if(sum<0){
                lo++;
            }else{
                res.add(Arrays.asList(nums[i],nums[lo++],nums[hi--]));//nusm
                while(lo<hi&&nums[lo]==nums[lo-1]){
                    lo++;
                }
            }
        }
    }
}
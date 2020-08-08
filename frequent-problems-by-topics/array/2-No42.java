class Solution {
	//brute force O(n^2) O(1)
    public int trap(int[] height) {
        int res = 0;//initialize
        for(int i = 1; i<height.length-1; i++){
            int lMax = Integer.MIN_VALUE;
            int rMax = Integer.MIN_VALUE;
            for(int j = 0; j < i; j++){
                lMax = Math.max(lMax,height[j]);//height
            }
            for(int k = i+1; k < height.length; k++){
                rMax = Math.max(rMax,height[k]);//height
            }
            res += Math.max(0,Math.min(lMax,rMax)-height[i]);//!
        }
        return res;
    }
}
//Dynamic Programming O(n) O(n)
//array left_max right_max 

// Using stacks  O(n) O(n)

//Using 2 pointers  O(n) O(1)
/*
class Solution {
    public int trap(int[] height) {
        int res = 0;//initialize
        int left = 0;
        //int temp = 0;
        int right = height.length - 1;
        int lMax = Integer.MIN_VALUE;//UPPERCASE
        int rMax = Integer.MIN_VALUE;
        while(left < right){
            if(height[left]<height[right]){
                //temp = (height[left]>=lMax) ? (lMax=height[left++]) : (res+=lMax-height[left++]);//notice ; 
                if(height[left]>=lMax){ 
                    lMax=height[left++];
                }else{
                    res+=lMax-height[left++];
                }
            }else{
                //temp = (height[right]>=rMax) ? (rMax=height[right--]):(res+=rMax-height[right--]);//right --
                if(height[right]>=rMax){
                    rMax=height[right--];
                }else{
                    res+=rMax-height[right--];
                }
            }
        }
        return res;
    }
}
*/



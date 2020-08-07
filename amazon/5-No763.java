class Solution {
    public List<Integer> partitionLabels(String S) {
        int[] last = new int[26];
		for(s.length){
			last[S.charAt(i)-'a']=i;
		}
		int j, anchor;
		List<Integer> ans ;
		for(S.length){
			j=Math.max(j,last[S.charAt(i)-'a']);//a`b`a
			if(i==j){
				ans.add(i-anchor+1);
				anchor=i+1;
			}
		}
		return ans;
    }
}
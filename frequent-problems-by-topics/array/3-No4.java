class Solution {
	//O(log(min(m,n))) O(1)
    public double findMedianSortedArrays(int[] A, int[] B) {
        int m = A.length, n = B.length;
        if(m>n){
            int[] temp = A; A = B; B = temp;// expression ;
            int tmp = m; m = n; n = tmp;
        }
        int iMax = A.length, iMin = 0, half = (m + n + 1) / 2; //statement , half (m+n+1)/2
        while(iMin <= iMax){
            int i = (iMin + iMax) / 2;
            int j = half - i;
            if(i > iMin && A[i-1]>B[j]){
                iMax = i - 1;//iMax ~ i
            }else if(i < iMax && B[j -1]>A[i]){
                iMin = i + 1;//iMin ~ i
            }else{
                int lMax = 0;
                if(i==0){
                    lMax = B[j-1];
                }else if(j==0){
                    lMax = A[i - 1];
                }else{
                    lMax = Math.max(A[i-1],B[j-1]);//!
                }
                if((m+n)%2 == 1){return lMax;}//%
                
                int rMax = 0;
                if(i==m){
                    rMax = B[j];
                }else if(j==n){
                    rMax = A[i];
                }else{
                    rMax = Math.min(A[i],B[j]);
                }
                return (lMax+rMax)/2.0; //!!!2.0
            }
        }
        return 0.0;
    
    }
}
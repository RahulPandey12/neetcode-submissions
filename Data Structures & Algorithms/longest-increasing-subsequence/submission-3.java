class Solution {
    public int lengthOfLIS(int[] nums) {
        int nums1[] = nums.clone();
        int nums2[] = nums.clone();
        Arrays.sort(nums2);
             // Remove duplicates
        nums2 = Arrays.stream(nums2).distinct().toArray();
        return longestCommonSubsequence(nums1,nums2);
    }
       int t[][];
     public int longestCommonSubsequence(int[] nums1, int[] nums2) {
        int n=nums1.length;
        int m=nums2.length;
        t=new int[n+1][m+1];
      return longestCommonSubsequenceHelper(nums1,nums2,
      nums1.length,nums2.length);
    }

    public int longestCommonSubsequenceHelper(int[] nums1, int[] nums2,int n, int m){
        if(n==0 || m==0){
            return 0;
        }
   
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
          if(nums1[i-1]==(nums2[j-1])){
             t[i][j]=1+t[i-1][j-1];
          }
        else{
           t[i][j]=Math.max(t[i-1][j],t[i][j-1]);
        }
        }
        }
   return t[n][m];
    }
}

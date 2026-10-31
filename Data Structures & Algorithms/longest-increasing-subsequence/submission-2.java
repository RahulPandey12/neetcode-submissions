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
        for(int row[]: t){
            Arrays.fill(row,-1);
        }
      return longestCommonSubsequenceHelper(nums1,nums2,
      nums1.length,nums2.length);
    }

    public int longestCommonSubsequenceHelper(int[] nums1, int[] nums2,int n, int m){
        if(n==0 || m==0){
            return 0;
        }
        if(t[n][m]!=-1){
            return t[n][m];
        }
        
        if(nums1[n-1]==(nums2[m-1])){
            return t[n][m]=1+longestCommonSubsequenceHelper(nums1,nums2,n-1,m-1);
        }
        else{
          return t[n][m]=Math.max(longestCommonSubsequenceHelper(nums1,nums2,n-1,m),longestCommonSubsequenceHelper(nums1,nums2,n,m-1));
        }

    }
}

class Solution {
    int dp[];
    public int rob(int[] nums) {
         int n=nums.length;
        dp=new int[n+1];
        return robHelper(nums,n);
    }
    public int robHelper(int[] nums,int n){
        dp[0]=0;
        dp[1]=nums[0];
        for(int i=2;i<n+1;i++){
          dp[i]= Math.max(nums[i-1]+dp[i-2],dp[i-1]);
       }
       return dp[n];
}
}

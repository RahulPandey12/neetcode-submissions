class Solution {
    int dp[];
    public int rob(int[] nums) {
         int n=nums.length;
             if (n == 1) {
             return nums[0];
    }
        dp=new int[n+1];
        return Math.max(robHelper(nums,0,n-2),robHelper(nums,1,n-1));
    }
    public int robHelper(int[] nums,int start, int end){
        dp[0]=0;
        dp[1]=nums[start];
        int n=end-start+1;
        for(int i=2;i<n+1;i++){
        dp[i] =Math.max(
            nums[start+i-1]+dp[i-2],
            dp[i-1]);
    }
    return dp[n];
    }
}

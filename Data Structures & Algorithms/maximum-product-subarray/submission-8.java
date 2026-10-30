class Solution {
    int dp[][];
    public int maxProduct(int[] nums) {
        dp=new int[nums.length+1][4];
        for(int row[]:dp){
            Arrays.fill(row,Integer.MIN_VALUE);
        }
        // Base case
        dp[0][0] = nums[0];
        dp[0][1] = nums[0];
        dp[0][2] = nums[0];
       for(int i=1;i<nums.length;i++){
        int num=nums[i];
        int currentMax=Math.max(num,Math.max(num*dp[i-1][0],num*dp[i-1][1]));
        int currentMin=Math.min(num,Math.min(num*dp[i-1][0],num*dp[i-1][1]));
        int maxProduct=Math.max(currentMax,dp[i-1][2]);
          dp[i][0] = currentMax;
          dp[i][1] = currentMin;
          dp[i][2] = maxProduct;
    }
    return dp[nums.length-1][2];
    }

}

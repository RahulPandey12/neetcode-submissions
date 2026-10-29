class Solution {
    int dp[];
    public int minCostClimbingStairs(int[] cost) {
        int n=cost.length;
        dp=new int[n+1];
        Arrays.fill(dp, -1);
        return minCostClimbingStairsHelper(cost,n);
        
    }
    public int minCostClimbingStairsHelper(int[] cost,int n){
       if(n==0 || n==1){
         return 0;
       }
        if(dp[n]!=-1){
            return dp[n];
        }
         return dp[n]=Math.min(cost[n - 1]+minCostClimbingStairsHelper(cost,n-1),cost[n - 2]+minCostClimbingStairsHelper(cost,n-2));



    }
}

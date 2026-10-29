class Solution {
    int dp[];
     public int climbStairs(int n) {
        dp = new int[n + 1];
        Arrays.fill(dp, -1);

        return climbStairsHelper(n);
    }

    public int climbStairsHelper(int n) {
  
        if(n==0  || n==1){
            return 1;
        }
        if(dp[n]!=-1){
            return dp[n];
        }
        return dp[n]=climbStairsHelper(n-1)+climbStairsHelper(n-2);
        
    }
}

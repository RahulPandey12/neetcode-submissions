class Solution {
    int dp[];
     public int climbStairs(int n) {
        dp = new int[n + 1];
        Arrays.fill(dp, -1);

        return climbStairsHelper(n);
    }

    public int climbStairsHelper(int n) {
  
       dp[0]=1;
       dp[1]=1;
        if(dp[n]!=-1){
            return dp[n];
        }
     dp[n]=climbStairsHelper(n-1)+climbStairsHelper(n-2);
     return dp[n];
        
    }
}

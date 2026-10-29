class Solution {
    int dp[];
     public int climbStairs(int n) {
        dp = new int[n + 1];
        return climbStairsHelper(n);
    }

    public int climbStairsHelper(int n) {
       dp[0]=1;
       dp[1]=1;
    for(int i=2;i<n+1;i++){
        dp[i]=dp[i-1]+dp[i-2];   
        }
    return dp[n];
    }
}

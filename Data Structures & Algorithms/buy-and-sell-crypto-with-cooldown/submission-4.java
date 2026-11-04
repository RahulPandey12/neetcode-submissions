class Solution {
    int max=Integer.MIN_VALUE;
    int dp[][];
    public int maxProfit(int[] prices) {
        int n=prices.length;
        dp=new int[n+2][2];
        return maxProfitHelper(prices, n-1,1);
        
    }
    public int maxProfitHelper(int[] prices, int n,int canBuy){
        dp[n][0]=0;
        dp[n][1]=0;
        int buyStock=0;
        int sellStock=0;
        for(int i=n;i>=0;i--){
            for(int j=0;j<2;j++){
        if(j==1){
           dp[i][j]=Math.max(-prices[i]+dp[i+1][0]
           ,dp[i+1][1]);
        }
        else{
dp[i][j]= Math.max(prices[i]+dp[i+2][1],
dp[i+1][0]);
        }
            }
        }
        return dp[0][1];
    }
        }


class Solution {
    int max=Integer.MIN_VALUE;
    int dp[][];
    public int maxProfit(int[] prices) {
        dp=new int[prices.length][2];
        for(int row[]: dp){
            Arrays.fill(row,-1);
        }
        return maxProfitHelper(prices, 0,1);
        
    }
    public int maxProfitHelper(int[] prices, int i,int canBuy){
        if(i>=prices.length){
            return 0;
        }
        if(dp[i][canBuy]!=-1){
            return dp[i][canBuy];
        }
        int buyStock=0;
        int sellStock=0;
        if(canBuy==1){
           buyStock=Math.max(-prices[i]+maxProfitHelper(prices,i+1,0)
           ,maxProfitHelper(prices,i+1,1));
        }
        else{
sellStock= Math.max(prices[i]+maxProfitHelper(prices,i+2,1),
maxProfitHelper(prices,i+1,0));
        }
        return dp[i][canBuy]=Math.max(buyStock,sellStock);

    }

}

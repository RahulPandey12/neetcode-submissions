class Solution {
    public int maxProfit(int[] prices) {
       int minPriceToBuy= prices[0];
       int profit=0;
        for(int i=1;i<prices.length;i++){
            minPriceToBuy =Math.min(minPriceToBuy,prices[i]);
            profit=Math.max(profit,prices[i]-minPriceToBuy);
        }
        return profit;
    }
       
}

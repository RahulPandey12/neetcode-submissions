class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit=0;
        int i=0;
        int sellPrice=0;
        while(i<prices.length){
          int buyPrice =prices[i];  //10
          int sellPoint=i+1; 
           while(sellPoint<prices.length){
            if(buyPrice<prices[sellPoint]){
              maxProfit=Math.max(maxProfit,(prices[sellPoint]-buyPrice));
           }
           else{
               break;
           }
           sellPoint++;
           }
           i++;
        }
        return maxProfit;
    }
}

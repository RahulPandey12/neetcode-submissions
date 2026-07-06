class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit=0;
        int i=0;
        while(i<prices.length){
          int buyPrice =prices[i];  //10
          int j=i+1; 
           while(j<prices.length){
            if(buyPrice<prices[j]){
              maxProfit=Math.max(maxProfit,(prices[j]-buyPrice));
           }
           else{
               break;
           }
           j++;
           }
           i++;
        }
        return maxProfit;
    }
}

class Solution {
    public int maxProfit(int[] prices) {
        int buyPrice = Integer.MAX_VALUE;
        int profitIfSoldToday = 0;
        int overallProfit = 0;
        for(int i=0;i<prices.length;i++){
            if(buyPrice > prices[i])
                buyPrice = prices[i];
            profitIfSoldToday = prices[i] - buyPrice;
            if(profitIfSoldToday > overallProfit){
                overallProfit = profitIfSoldToday;
            }
        }
        return overallProfit;
    }
}
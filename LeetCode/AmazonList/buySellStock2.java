class Solution {
    public int maxProfit(int[] prices) {
        int[] profitHistory = new int[prices.length];
        int profitIfSoldToday = Integer.MIN_VALUE;
        int buyPrice = prices[0];
        for(int i=0;i<prices.length;i++){
            profitIfSoldToday = prices[i] - buyPrice;
            if(profitIfSoldToday > 0){
                profitHistory[i] = profitIfSoldToday;
                buyPrice = prices[i];
            } else {
                buyPrice = prices[i];
                profitHistory[i] = 0;
            }
        }
        int maxProfit = 0;
        for(int i: profitHistory){
            maxProfit += i;
        }
        return maxProfit;
    }
}
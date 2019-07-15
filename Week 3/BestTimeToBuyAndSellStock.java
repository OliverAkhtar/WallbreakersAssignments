class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length <= 1)
            return 0;
        
        int maxProfit = 0, currentProfit = 0, lowestPrice = prices[0];
        
        for(int i = 1; i < prices.length; i++){
            if(prices[i] < lowestPrice)
                lowestPrice = prices[i];
            
            currentProfit = prices[i] - lowestPrice;
            
            if(currentProfit > maxProfit)
                maxProfit = currentProfit;
        }
        
        return maxProfit;
    }
}
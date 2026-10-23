class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;

        int currBuy = 0;
        int nextBuy = 0;
        int nextNextBuy = 0;

        int currHold = 0;
        int nextHold = 0;

        for(int i = n - 1; i >= 0; i--){
            currBuy = Math.max(-prices[i] + nextHold, nextBuy);

            currHold = Math.max(prices[i] + nextNextBuy, nextHold);

            nextNextBuy = nextBuy;
            nextBuy = currBuy;
            nextHold = currHold;
        }

        return currBuy;
    }
}
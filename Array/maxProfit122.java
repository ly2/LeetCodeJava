public class maxProfit122 {


    // this func is used to find the only one transation that can make max profit.
    // however, the question need us to make transactions as many as possible.
    public int maxProfit_Wrong(int[] prices) {
        if (prices.length <2)
            return 0;
        int max = 0;
        int prev_min = prices[0];

        for (int i =1; i < prices.length ;i++) {
            max = Math.max(max, prices[i]- prev_min);
            prev_min = Math.min(prev_min, prices[i]);
        }
        return max;
    }


    public int maxProfit(int[] prices) {
        int maxprofit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1])
                maxprofit += prices[i] - prices[i - 1];
        }
        return maxprofit;
    }
}

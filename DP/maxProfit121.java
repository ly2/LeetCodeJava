public class maxProfit121 {
    public int maxProfit(int[] prices) {
        if (prices.length == 0 ||prices.length == 1 )
            return 0;
        int max = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length;i++) {
            if (prices[i] < min)
                min = prices[i];
            else {
                max = Math.max(max, prices[i] - min);
            }


        }

        return max;
    }
}

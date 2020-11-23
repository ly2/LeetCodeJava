/**
 * You are given coins of different denominations and a total amount of money.
 * Write a function to compute the number of combinations that make up that amount.
 * You may assume that you have infinite number of each kind of coin.
 *
 */
public class CoinChangeII518 {
    /**
     * best method
     * @param amount
     * @param coins
     * @return
     */
    public int change(int amount, int[] coins) {
        int[] dp= new int[amount+1];
        dp[0]=1;
        for(int i=0;i<coins.length;i++){
            for(int j=coins[i];j<dp.length;j++){
                dp[j]+=dp[j-coins[i]];
            }
        }
        return dp[amount];

    }

    /**
     * bottem 2D dp
     * 6 ms 51.39%
     * 45.7 MB 36.21%
     * @param amount
     * @param coins
     * @return
     */
//    public int change(int amount, int[] coins) {
//        int[][] dp = new int[coins.length + 1][amount + 1];
//        dp[0][0] = 1;
//        for (int j = 1; j <= coins.length; j++) {
//            dp[j][0] = 1; // number ways of selecting for amount zero is 1
//            for (int i = 1; i <= amount; i++) {
//                dp[j][i] = dp[j - 1][i]; // exclude current coin
//                if (i - coins[j - 1] >= 0) { // check if amount  >= to the current i`th coin
//                    dp[j][i] += dp[j][i - coins[j - 1]]; // include current coin
//                }
//            }
//        }
//        return dp[coins.length][amount];
//    }


//    also Time Limit Exceeded(recursive method)
//    public int change(int amount, int[] coins) {
//        return change(amount, coins, 0);
//    }
//
//    private int change(int amount, int[] coins, int i) {
//        if (amount < 0) return 0; // if amount is negative by which means not valid - 0
//        if (amount == 0) return 1; // we found exact change
//        if (i == coins.length && amount > 0) return 0; // means coins over and n>0 so no solution
//        return change(amount - coins[i], coins, i) + change(amount, coins, i + 1); // include + exclude
//    }


//    original method
//    int[] c;
//    public int change(int amount, int[] coins) {
//        if (amount==0 && coins.length==0)
//            return 1;
//
//        c = coins;
//        int res = coincomb(amount, 0);
//
//        return res;
//
//    }
//
//    private int coincomb(int amount, int index) {
//        if (index >= c.length)
//            return 0;
//        int i = 0;
//        int res = 0;
//        while (i*c[index] <= amount) {
//            if (i*c[index] == amount) {
//                res++;
//            } else {
//                res += coincomb(amount-i*c[index], index+1);
//            }
//            i++;
//        }
//        return res;
//    }
}

import java.util.Arrays;

/**
 * You are given coins of different denominations and a total amount of money amount.
 * Write a function to compute the fewest number of coins that you need to make up that amount.
 * If that amount of money cannot be made up by any combination of the coins, return -1.
 */


public class CoinChange322 {

    /**
     * 11 ms	38.8 MB
     * classic dp question, O(n) time. and use recurrence method to build f array for every amount (0,1,2,3...amount)
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        int[] f = new int[amount+1];
        f[0] = 0;
        for (int i = 1; i < amount+1; i++) {
            int min = amount+1;
            for (int c: coins) {
                if (i - c >= 0 && f[i-c] != -1) {
                    min = Math.min(min, f[i-c]+1);
                }
            }
            if (min == amount+1)
                f[i] = -1;
            else
                f[i] = min;
        }
        return f[amount];
    }


    /**
     * 8 ms	38.7 MB
     * an improved version, a little faster than above one.
     * @param coins
     * @param amount
     * @return
     */
//    public int coinChange(int[] coins, int amount) {
//        int[] opt = new int[amount+1];
//        Arrays.fill(opt, amount+1);
//        opt[0] = 0;
//        for(int c = 0; c < coins.length; c++){
//            int v = coins[c];
//            if(v <= amount){
//                opt[v] = 1;
//                for(int a = 1; a+v <= amount; a++){
//                    opt[a+v] = Math.min(opt[a] + 1, opt[a+v]);
//                }
//            }
//        }
//        if(opt[amount] > amount){
//            opt[amount] = -1;
//        }
//        return opt[amount];
//    }
}

/**
 * You are climbing a stair case. It takes n steps to reach to the top.
 *
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 */

public class ClimbingStairs70 {

    /**
     *  simple dp, use loop
     * @param n
     * @return
     */
//    public int climbStairs(int n) {
//        if (n<=2)
//            return n;
//        int[] nums = new int[n+1];
//        nums[1] = 1;
//        nums[2] = 2;
//        for (int i = 3; i <=n; i++) {
//            nums[i] = nums[i-1] + nums[i-2];
//        }
//
//
//        return nums[n];
//    }

    /**
     * official solution, which is an Improved version of above one.
     * do not need to use an array to store all solution for n (1,2,3,4,5,6....n) length stair.
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        int first = 1;
        int second = 2;
        for (int i = 3; i <= n; i++) {
            int third = first + second;
            first = second;
            second = third;
        }
        return second;
    }
}

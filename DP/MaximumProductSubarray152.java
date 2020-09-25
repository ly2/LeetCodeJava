import java.util.Arrays;

/**
 * Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.
 */


public class MaximumProductSubarray152 {
    /**
     *  brute force method, 160 ms	39.1 MB
     * @param nums
     * @return
     */
//    public int maxProduct(int[] nums) {
//
//        if (nums.length == 0)
//            return 0;
//        if (nums.length == 1)
//            return nums[0];
//
//        int[] res = new int[nums.length];
//        Arrays.fill(res, 1);
//
//        int max = nums[0];
//        for (int i = 0; i < nums.length; i ++) {
//            for (int j = 0; j < nums.length - i; j ++) {
//                res[j] = res[j]*nums[j+i];
//                max = Math.max(res[j], max);
//            }
//        }
//
//        return max;
//
//    }

    /**
     *   calculate the positive product and negative product for each num, store the maximum positive product in max.
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {
        if (nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];
        int pos;
        int neg;
        if (nums[0] >= 0) {
            pos = nums[0];
            neg = 0;
        } else {
            pos = 0;
            neg = nums[0];
        }
        int max = pos;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > 0) {
                pos = pos== 0? nums[i]: pos*nums[i];
                neg = neg*nums[i];
            } else if (nums[i] < 0) {
                int tmp = pos;
                pos = neg*nums[i];
                neg = tmp== 0? nums[i]:tmp*nums[i];

            } else {
                pos = 0;
                neg = 0;
            }
            max = Math.max(pos, max);
        }

        return max;
    }

}

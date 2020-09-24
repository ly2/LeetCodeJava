import java.util.Arrays;

/**
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed.
 * All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile,
 * adjacent houses have security system connected and it will automatically contact the police
 * if two adjacent houses were broken into on the same night.
 *
 * Given a list of non-negative integers representing the amount of money of each house,
 * determine the maximum amount of money you can rob tonight without alerting the police.
 */

public class HouseRobberII213 {


    int[] memo;
    int[] memo2;
    public int rob(int[] nums) {
        if (nums.length==0)
            return 0;

//        if (nums.length <= 3) {
//            Arrays.sort(nums);
//            return nums[nums.length-1];
//        }
        memo = new int[nums.length + 1];
        memo2 = new int[nums.length + 1];
        Arrays.fill(memo, -1);
        Arrays.fill(memo2, -1);
        int max = Math.max(rob(nums, nums.length - 3, 1) + nums[nums.length - 1], rob(nums, nums.length - 3, 0));
        return Math.max(max, rob(nums, nums.length - 2,0));
    }

    private int rob(int[] nums, int i, int end) {
        if (i < end) {
            return 0;
        }
        if (end == 1) {
            if (memo[i] >= 0) {
                return memo[i];
            }
            int result = Math.max(rob(nums, i - 2, end) + nums[i], rob(nums, i - 1, end));
            result = Math.max(result, rob(nums, i - 3, end));
            memo[i] = result;
            return result;
        }else {
            if (memo2[i] >= 0) {
                return memo2[i];
            }
            int result = Math.max(rob(nums, i - 2, end) + nums[i], rob(nums, i - 1, end));
            result = Math.max(result, rob(nums, i - 3, end));
            memo2[i] = result;
            return result;
        }
    }

}

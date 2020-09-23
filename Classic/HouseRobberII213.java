import java.util.Arrays;

/**
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
 *
 * Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
 */

public class HouseRobberII213 {

    public int rob(int[] nums) {
        if (nums.length==0)
            return 0;

        if (nums.length <= 3) {
            Arrays.sort(nums);
            return nums[nums.length-1];
        }
        if (nums.length%2 == 0) {
            int r1=0, r2 = 0;
            for (int i = 0; i < nums.length-1;i +=2) {
                r1 += nums[i];
                r2 += nums[i+1];
            }
            return r1>r2 ? r1:r2;
        } else {
            int max = 0;
            for (int i = 0; i < nums.length;i++) {
                int r = run(nums, i);
                if (r > max)
                    max = r;
            }
            return max;
        }
    }

    private int run(int[] nums, int index) {
        int l = nums.length/2-2;
        int r = nums[index];
        index+=3;
        if (index >= nums.length)
            index -= nums.length;
        r += nums[index];
        while (l > 0) {
            index+=2;
            if (index >= nums.length)
                index -= nums.length;
            r += nums[index];
            l--;
        }

        return r;
    }


}

import java.util.ArrayList;
import java.util.List;

/**
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
 *
 * Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
 */


public class HouseRobber198 {
    // classic dp question, is similar to house robber 2
    public int rob(int[] nums) {
        if (nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];
        if (nums.length == 2)
            return Math.max(nums[0], nums[1]);

        int prev2 = nums[0];
        int prev1 = Math.max(nums[0], nums[1]);

        int curr =0;
        for (int i = 2; i < nums.length;i++) {
            curr = Math.max((nums[i]+prev2), prev1);
            prev2 = prev1;
            prev1 = curr;

        }
        return curr;
    }

}

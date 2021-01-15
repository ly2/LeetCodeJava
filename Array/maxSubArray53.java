public class maxSubArray53 {

    //
    public int maxSubArray(int[] nums) {
        int sum = 0, max = nums[0];
        for (int i : nums) {
            sum += i;
            if(sum > max) max = sum;
            if(sum < 0) sum = 0;
        }
        return max;
    }

    // greedy
    public int maxSubArray1(int[] nums) {
        int n = nums.length;
        int currSum = nums[0], maxSum = nums[0];

        for(int i = 1; i < n; ++i) {
            currSum = Math.max(nums[i], currSum + nums[i]);
            maxSum = Math.max(maxSum, currSum);
        }
        return maxSum;
    }


    //
    public int maxSubArray2(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        int[] sum = new int[nums.length+1];
        for (int i = 0; i<nums.length;i++) {
            sum[i+1] = sum[i]+nums[i];
        }

        int[] dp = new int[nums.length+1];
        dp[0] = Integer.MIN_VALUE;;

        for (int i = 1; i<nums.length+1;i++) {
            int max = dp[i-1];
            for (int j =  i-1; j >= 0; j--) {
                max = Math.max(max, sum[i]-sum[j]);
            }
            dp[i] = max;
        }
        return dp[dp.length-1];
    }
}

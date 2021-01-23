public class minStartValue1413 {

    public int minStartValue(int[] nums) {
        int min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i-1];
            min = Math.min(min, nums[i]);
        }

        return min > 0? 1: 1-min;
    }


    // the method it handle the 1 situation is great( if all positive int, the min will be 0)
    public int minStartValue2(int[] nums) {
        int sum = 0, minPrefixSum = 0;
        for (int n : nums) {
            sum += n;
            minPrefixSum = Math.min(sum, minPrefixSum);
        }
        return 1 - minPrefixSum;
    }
}

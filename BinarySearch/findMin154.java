public class findMin154 {

    public int findMin(int[] nums) {
        int start = 0, end = nums.length-1, res = nums[0];

        while (start  <= end) {
            int median = (end-start)/2+start;

            if (nums[median] > nums[start] ) {
                start = median+1;
            } else if (nums[median] < nums[start]) {
                end = median;
            } else {
                start++;
            }

            if (start < nums.length) {
                res = Math.min(nums[start], res);
            }
        }


        return res;
    }



}

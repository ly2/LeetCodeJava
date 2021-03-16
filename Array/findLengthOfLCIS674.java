public class findLengthOfLCIS674 {
    public int findLengthOfLCIS(int[] nums) {
        if (nums.length == 0)
            return 0;
        int lcis = 1;
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i-1]) {
                count++;
//                lcis = Math.max(lcis, count);

                //  use a if statement faster than Math.max
                if (count> lcis) {
                    lcis = count;
                }
            } else {
                count = 1;
            }


        }
        return lcis;

    }

    // 0ms
    public int findLengthOfLCIS2(int[] nums) {

        int maxLen = 1;
        int len = 1;
        int n = nums.length;
        if( n == 0){
            return 0;
        }
        for(int i = 1; i < n; i++){
            if(nums[i - 1] >= nums[i]){
                if(maxLen <  len){
                    maxLen = len;
                }
                len = 0;
            }
            len++;
        }
        if(maxLen <  len){
            maxLen = len;
        }
        return maxLen;
    }
}

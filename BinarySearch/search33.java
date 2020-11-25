public class search33 {


    public int search(int[] nums, int target) {

        int start = 0, end = nums.length-1, index = -1;
        while (start <= end) {

            if (nums[start] == target)
                return start;

            if(start == end)
                return -1;

            int median = start + (end-start)/2;

            if (nums[median] == target) {
                return median;
            } else if (nums[median] < target) {
                if (nums[median] > nums[start] || target <= nums[end] ) {
                    start = median+1;
                } else if (nums[median] < nums[start] ){
                    end = median;
                } else {
                    start++;
                }

            } else {

                if (nums[median] < nums[start] || target >= nums[start]) {
                    end = median;
                } else if (target <= nums[end] ){
                    start = median+1;
                } else {
                    start++;
                }
            }


        }
        return index;
    }
}

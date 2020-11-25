public class sortArray912 {
    public int[] sortArray(int[] nums) {
        if ( nums.length == 1)
            return nums;

         mergesort(nums, 0, nums.length-1);
        return nums;
    }


    public void mergesort(int[] nums, int start, int end) {
        if (start < end) {
            int median = (end + start) / 2;
            mergesort(nums, start, median);
            mergesort(nums, median + 1, end);
            merged(nums, start, end, median);
        }
    }

    public void merged(int[] nums, int start, int end, int median) {
        int[] tmp = new int[end-start+1];
        int i = start, j = median+1, k = 0;
        while (i <= median && j <= end) {
            if (nums[i] <= nums[j]) {
                tmp[k++] = nums[i++];
            } else {
                tmp[k++] = nums[j++];
            }
        }
        while (i <= median)
            tmp[k++] = nums[i++];
        while (j <= end)
            tmp[k++] = nums[j++];

        for (int x = 0; x < tmp.length;x++) {
            nums[x+start] = tmp[x];
        }
    }

}

public class removeDuplicates26 {


    public int removeDuplicates(int[] nums) {
        if (nums.length == 0)
            return 0;

        int new_len = 1;

        for (int i = 1; i < nums.length;i++) {
            if (nums[i] != nums[i-1]) {
                if (i != new_len) {
                    nums[new_len ] = nums[i];
                }
                new_len++;
            }

        }

        return new_len;
    }

}

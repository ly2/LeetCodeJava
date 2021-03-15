public class shuffle1470 {

    public int[] shuffle(int[] nums, int n) {
        int[] res = new int[nums.length];
        int i = 0, j = n, idx = 0;
        while (i < n) {
            res[idx++] = nums[i++];
            res[idx++] = nums[j++];
        }
        return res;
    }
}

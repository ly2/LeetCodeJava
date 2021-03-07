import java.util.Arrays;

public class sortedSquares977 {

    // original
    public int[] sortedSquares1(int[] nums) {
        int[] res = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            res[i] = nums[i]*nums[i];
        }
        Arrays.sort(res);
        return res;

    }


    // just one scan!
    public int[] sortedSquares(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];

        // if no negative num, just square the value.
        if (nums[0] >= 0) {
            for (int i = 0; i < nums.length; i++) {
                res[i] = nums[i]*nums[i];
            }
        } else {
            int i = 0;
            for ( ; i < len; i++) {
                if (nums[i] >= 0)
                    break;
            }
            int j = i-1;
            int idx = 0;
            while (j>= 0 && i < len) {
                if (nums[i]*nums[i] < nums[j] * nums[j]) {
                    res[idx++] =  nums[i]*nums[i];
                    i++;
                } else {
                    res[idx++] =  nums[j]*nums[j];
                    j--;
                }
            }
            while (j>= 0) {
                res[idx++] =  nums[j]*nums[j];
                j--;
            }
            while (i < len) {
                res[idx++] =  nums[i]*nums[i];
                i++;
            }
        }
        return res;
    }

    // two pointer
    public int[] sortedSquares2(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int left = 0;
        int right = n - 1;

        for (int i = n - 1; i >= 0; i--) {
            int square;
            if (Math.abs(nums[left]) < Math.abs(nums[right])) {
                square = nums[right];
                right--;
            } else {
                square = nums[left];
                left++;
            }
            result[i] = square * square;
        }
        return result;
    }
}

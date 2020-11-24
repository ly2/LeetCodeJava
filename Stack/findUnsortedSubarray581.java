import java.util.Arrays;
import java.util.Stack;

public class findUnsortedSubarray581 {



    public int findUnsortedSubarray(int[] nums) {
        int[] sorted = nums.clone();
        Arrays.sort(sorted);
        int i = 0;
        while (i < nums.length) {
            if (sorted[i] == nums[i]) {
                i++;
            } else {
                break;
            }
        }
        int head = i;
        if (i == nums.length)
            return 0;

        i = nums.length-1;
        while (i >= 0) {
            if (sorted[i] == nums[i]) {
                i--;
            } else {
                break;
            }
        }

        return i-head+1;
    }


    // offical
    // time complexity O(n) space complexity O(n)
    //
    public int findUnsortedSubarray2(int[] nums) {
        Stack< Integer > stack = new Stack < Integer > ();
        int l = nums.length, r = 0;
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] > nums[i])
                l = Math.min(l, stack.pop());
            stack.push(i);
        }
        stack.clear();
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i])
                r = Math.max(r, stack.pop());
            stack.push(i);
        }
        return r - l > 0 ? r - l + 1 : 0;
    }


    // offical2
    // time complexity O(n) space complexity O(1)
    //
    public int findUnsortedSubarray3(int[] nums) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        boolean flag = false;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1])
                flag = true;
            if (flag)
                min = Math.min(min, nums[i]);
        }
        flag = false;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] > nums[i + 1])
                flag = true;
            if (flag)
                max = Math.max(max, nums[i]);
        }
        int l, r;
        for (l = 0; l < nums.length; l++) {
            if (min < nums[l])
                break;
        }
        for (r = nums.length - 1; r >= 0; r--) {
            if (max > nums[r])
                break;
        }
        return r - l < 0 ? 0 : r - l + 1;
    }
}


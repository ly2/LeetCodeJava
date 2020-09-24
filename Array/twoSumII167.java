import java.util.HashMap;
import java.util.Map;

/**
 *
 *Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.
 *
 * The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.
 *
 * Note:
 *
 * Your returned answers (both index1 and index2) are not zero-based.
 * You may assume that each input would have exactly one solution and you may not use the same element twice.
 *
 *
 */

public class twoSumII167 {
    /**
     * brute force method 239 ms	40 MB
     * @param numbers
     * @param target
     * @return
     */
//    public int[] twoSum(int[] numbers, int target) {
//        if (numbers.length == 2) {
//            return new int[]{1, 2};
//        }
//        for (int i = 0; i < numbers.length-1;i++) {
//            for (int j = i+1; j <numbers.length;j++ ) {
//                if (numbers[i]+numbers[j] == target){
//                    return new int[] {i+1,j+1};
//                } else if (target - numbers[i] < numbers[j])
//                    break;
//            }
//        }
//
//        return null;
//    }


    /**
     * 2 ms	39.6 MB, use a hashmap
     * @param numbers
     * @param target
     * @return
     */
//    public int[] twoSum(int[] numbers, int target) {
//        if (numbers.length == 2) {
//            return new int[]{1, 2};
//        }
//        HashMap<Integer, Integer> hashMap = new HashMap<>();
//        for (int i =0; i < numbers.length;i++) {
//            if (hashMap.containsKey(numbers[i]))
//                return new int[]{ hashMap.get(numbers[i])+1,i+1};
//            hashMap.put(target-numbers[i], i);
//        }
//        return  null;
//    }

    /**
     * 0ms
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low < high) {
            int sum = nums[low] + nums[high];
            if (sum == target) {
                return new int[] {low + 1, high + 1};
            } else if (sum < target) {
                ++low;
            } else {
                --high;
            }
        }
        return new int[]{-1, -1};
    }

}

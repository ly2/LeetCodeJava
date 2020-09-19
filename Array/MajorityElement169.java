
/*
Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.\
You may assume that the array is non-empty and the majority element always exist in the array.

*/



import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MajorityElement169 {
    public int majorityElement(int[] nums) {

        int n = nums.length/2;
        HashMap<Integer, Integer> counter = new HashMap<Integer, Integer>();
        for (int i : nums) {

            if (counter.containsKey(i)) {
                Integer oldValue = counter.get(i);
                counter.put(i, oldValue+1);
            } else {
                counter.put(i, 1);
            }
            if (counter.get(i) > n) {
                return i;
            }

        }
        for (Map.Entry<Integer, Integer> pair: counter.entrySet()) {
            if (pair.getValue() > n)
                return pair.getKey();
        }
        return 0;


/*        Arrays.sort(nums);
        return nums[nums.length/2];*/
    }
}

import java.util.Arrays;
import java.util.HashMap;

public class singleNumber136 {
    public int singleNumber(int[] nums) {
        if (nums.length == 1)
            return nums[0];

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int n : nums) {
            if (map.getOrDefault(n, 0) == 0) {
                map.put(n, 1);
            } else {
                map.put(n, map.get(n)-1);
            }
        }
        for (int n: map.keySet()) {
            if (map.get(n) != 0)
                return n;
        }



        return 0;
    }


    // bit manipulation
    public int singleNumber2(int[] nums) {
        int a = 0;
        for (int i : nums) {
            a ^= i;
        }
        return a;
    }


    public int singleNumber3(int[] nums) {
        if (nums.length == 1) return nums[0];

        Arrays.sort(nums);

        //If first element is not equal to second, first must be the single element
        if (nums[1] != nums[0]) return nums[0];

        for (int i = 1; i < nums.length - 1; i++) {
            //If the element before and the element after is different, found single element
            if (nums[i-1] != nums[i] && nums[i+1] != nums[i]) {
                return nums[i];
            }
        }

        //If we made it through the whole array, last one is the single element
        return nums[nums.length-1];
    }
}

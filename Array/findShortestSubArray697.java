import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class findShortestSubArray697 {

    public int findShortestSubArray(int[] nums) {
        if (nums.length == 1)
            return 1;
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int n : nums) {
            hashMap.put(n, hashMap.getOrDefault(n, 0)+1);
        }
        int max = -1;
        for (int count: hashMap.values()) {
            if (count > max)
                max = count;
        }
        int min = Integer.MAX_VALUE;
        for (int key: hashMap.keySet()) {
            if (hashMap.get(key) == max) {
                min = Math.min(min, length(nums, key));
            }
        }

        return min;
    }

    public int length(int[] nums, int target) {
        int start = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                start = i;
                break;
            }
        }
        int end = nums.length-1;
        for (int i= nums.length-1; i>=0;i--) {
            if (nums[i] == target) {
                end = i;
                break;
            }
        }
        return end-start+1;
    }


    // official 17ms
    public int findShortestSubArray2(int[] nums) {
        Map<Integer, Integer> left = new HashMap(),
                right = new HashMap(), count = new HashMap();

        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            if (left.get(x) == null) left.put(x, i);
            right.put(x, i);
            count.put(x, count.getOrDefault(x, 0) + 1);
        }

        int ans = nums.length;
        int degree = Collections.max(count.values());
        for (int x: count.keySet()) {
            if (count.get(x) == degree) {
                ans = Math.min(ans, right.get(x) - left.get(x) + 1);
            }
        }
        return ans;
    }


    // submission method! 2ms
    // use left to store the first occurrence of value, right is the last occurence of value
    // count to find the degree
    public int findShortestSubArray3(int[] nums) {
        int max = 0;
        for(int i : nums)
            max = Math.max(max, i);

        int[] count = new int[max+1];
        int[] left = new int[max+1];
        int[] right = new int[max+1];

        for(int i = 0; i < nums.length; i++){
            if(count[nums[i]] == 0)
                left[nums[i]] = i;
            right[nums[i]] = i;
            count[nums[i]]++;
        }

        int degree = 0;
        int min = Integer.MAX_VALUE;

        for(int i = 0; i < count.length; i++){
            if(count[i] >= degree){
                degree = count[i];
            }
        }

        for(int x = 0; x < count.length; x++){
            if(count[x] == degree){
                min = Math.min(min, right[x] - left[x] + 1);
            }
        }

        return min;
    }

}

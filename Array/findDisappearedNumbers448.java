import java.util.ArrayList;
import java.util.List;

public class findDisappearedNumbers448 {

    // 5ms, no extra space and o(n) time
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int len = nums.length;
        for (int i = 0 ;i < len;i++) {
            nums[i] --;
            int idx = nums[i];
            if (idx >= len) {
                idx %= len;
            }
            nums[idx] += len;
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0 ;i < len;i++) {
            if (nums[i] < len) {
                list.add(i+1);
            }
        }
        return list;
    }


    // O(n) space because using a boolean array. 3ms
    public List<Integer> findDisappearedNumbers2(int[] nums) {
        int n = nums.length;
        boolean[] exist = new boolean[n + 1];
        for (int num : nums) {
            exist[num] = true;
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (!exist[i]) {
                ans.add(i);
            }
        }
        return ans;
    }
}

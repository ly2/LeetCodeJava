import java.util.ArrayList;
import java.util.List;

public class summaryRanges228 {

    public List<String> summaryRanges(int[] nums) {
        int prev = 0;
        ArrayList<String> list = new ArrayList<>();
        if (nums.length == 0)
            return list;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[prev] + i-prev) {
                if (i-prev > 1) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(nums[prev]).append("->").append(nums[i-1]);
                    list.add(sb.toString());
                } else {
                    list.add(Integer.toString(nums[prev]));
                }
                prev = i;
            }
        }
        if (prev < nums.length-1) {
            StringBuilder sb = new StringBuilder();
            sb.append(nums[prev]).append("->").append(nums[nums.length-1]);
            list.add(sb.toString());
        } else {
            list.add(Integer.toString(nums[prev]));
        }
        return list;
    }
}

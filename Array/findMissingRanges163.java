import java.util.ArrayList;
import java.util.List;

public class findMissingRanges163 {

    public List<String> findMissingRanges(int[] nums, int lower, int upper) {

        ArrayList<String> list = new ArrayList<>();
        for ( int num : nums) {
            if (num != lower ) {
                if (num-lower > 1) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(lower).append("->").append(num-1);
                    list.add(sb.toString());
                } else {
                    list.add(Integer.toString(lower));
                }

            }
            lower = num+1;
        }
        if (lower <= upper) {
            StringBuilder sb = new StringBuilder();
            sb.append(lower);
            if (lower!= upper) {
                sb.append("->").append(upper);
            }
            list.add(sb.toString());
        }

        return list;
    }
}

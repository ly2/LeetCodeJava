import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class subsets78 {


    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());

        for (int n: nums) {
            List<List<Integer>> l = new ArrayList<>();
            for (List<Integer> tmp: ans) {
                l.add(new ArrayList<Integer>(tmp){{add(n);}});
            }
            ans.addAll(l);
        }

        return ans;
    }
}

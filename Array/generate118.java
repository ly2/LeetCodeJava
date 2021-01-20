import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class generate118 {


    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();

        if (numRows == 0)
            return ans;
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        ans.add(list1);
        if (numRows == 1)
            return ans;

        List<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(1);
        ans.add(list2);
        if (numRows == 2)
            return ans;
        for (int i = 2; i < numRows; i++) {
            List<Integer> last = ans.get(i-1);
            List<Integer> tmp = new ArrayList<>();
            tmp.add(1);
            for (int j = 1; j < i; j++ ) {
                tmp.add(last.get(j)+last.get(j-1));
            }
            tmp.add(1);
            ans.add(tmp);
        }


        return ans;
    }
}

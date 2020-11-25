import java.util.ArrayList;
import java.util.List;

public class countSmaller315 {

    // 还是得用二叉树，然后记录小于当前节点值得数量，同时得记录index（防止重复）
    // use bst to solve the question, which need two more attributes.
    // the one is used for recording the count of smaller value
    // another one is used for recording the index of each value
    public List<Integer> countSmaller(int[] nums) {
        if (nums.length == 0)
            return new ArrayList<>();




        return null;
    }




    public List<Integer> countSmaller2(int[] nums) {
        if (nums.length == 0)
            return new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < nums.length-1;i++) {
            int c = 0;
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] > nums[j])
                    c++;
            }
            ans.add(c);
        }
        ans.add(0);
        return ans;
    }

}

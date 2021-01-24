import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class levelOrderBottom107 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    // much clean!!
    List<List<Integer>> levels = new ArrayList<List<Integer>>();
    public void helper(TreeNode node, int level) {
        // start the current level
        if (levels.size() == level)
            levels.add(new ArrayList<Integer>());

        // append the current node value
        levels.get(level).add(node.val);

        // process child nodes for the next level
        if (node.left != null)
            helper(node.left, level + 1);
        if (node.right != null)
            helper(node.right, level + 1);
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) return levels;
        helper(root, 0);
        Collections.reverse(levels);
        return levels;
    }





    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> levelOrderBottom2(TreeNode root) {
        if(root == null)
            return ans;
        ArrayList<TreeNode> list = new ArrayList<>();
        list.add(root);
        bfs(list);
        return ans;
    }

    public void bfs(List<TreeNode> list) {
        ArrayList<TreeNode> next = new ArrayList<>();
        ArrayList<Integer> level = new ArrayList<>();
        for(TreeNode node : list) {
            level.add(node.val);
            if(node.left != null)
                next.add(node.left);
            if(node.right != null)
                next.add(node.right);
        }
        ans.add(0, level);
        if(!next.isEmpty())
            bfs(next);
    }


}

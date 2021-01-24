import java.util.ArrayList;
import java.util.List;

public class binaryTreePaths257 {

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

//
//    List<String> ans = new ArrayList<>();
//    public List<String> binaryTreePaths(TreeNode root) {
//        path(root, "");
//        return ans;
//    }
//
//    public void path(TreeNode root, String s) {
//        if(root == null)
//            return;
//
//        if(root.left == null && root.right == null) {
//            ans.add(s+root.val);
//        } else {
//            path(root.left, s+root.val+"->");
//            path(root.right, s+root.val+"->");
//        }
//    }
    List<String> ans = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        path(root, new StringBuilder());
        return ans;
    }

    public void path(TreeNode root, StringBuilder s) {
        if(root == null)
            return;

        if(root.left == null && root.right == null) {
            ans.add(s.append(root.val).toString());
        } else {
            path(root.left, new StringBuilder(s).append(root.val).append("->"));
            path(root.right, new StringBuilder(s).append(root.val).append("->"));
        }
    }
}

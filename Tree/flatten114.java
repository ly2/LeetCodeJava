import java.util.ArrayList;
import java.util.List;

public class flatten114 {

    public static class TreeNode {
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


    public void flatten(TreeNode root) {

        subflatten(root);

    }

    public TreeNode subflatten(TreeNode node) {
        if (node == null)
            return null;
        if (node.right == null && node.left == null) {
            return node;
        }
        if (node.right != null && node.left == null ) {
            return subflatten(node.right);
        }
        if ( node.right == null && node.left != null) {
            node.right = node.left;
            node.left = null;
            return subflatten(node.right);
        }
        if (node.right != null && node.left != null) {
            TreeNode tail = subflatten(node.left);
            tail.right = node.right;
            node.right = node.left;
            node.left = null;
            return subflatten(tail.right);
        }

        return null;
    }



    // same use the preorder idea, but this method use a list to store the tree node then rebuild the tree.
    public void flatten2(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return;
        }
        List<TreeNode> list = new ArrayList<>();
        preorder(list, root);
        TreeNode cur = root;
        cur.left = null;
        for (int i = 1; i < list.size(); i++) {
            TreeNode node = list.get(i);
            node.left = null;
            cur.right = node;
            cur = cur.right;
        }
    }

    private void preorder(List<TreeNode> list, TreeNode root) {
        if (root == null) {
            return;
        }
        list.add(root);
        preorder(list, root.left);
        preorder(list, root.right);
    }


}

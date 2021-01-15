public class lowestCommonAncestor1644 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    boolean p_flag = false;
    boolean q_flag = false;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode ans = lca(root, p, q);
        return p_flag && q_flag ? ans : null;

    }

    public TreeNode lca(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return root;
        TreeNode left = lca(root.left, p, q);
        TreeNode right = lca(root.right, p, q);


        if (root.equals(p) ) {
            p_flag = true;
            return root;
        }

        if (root.equals(q)) {
            q_flag = true;
            return root;
        }

        if (left != null && right != null) {
            return root;
        }

        if (left == null && right == null)
            return null;


        return left != null? left: right;
    }
}

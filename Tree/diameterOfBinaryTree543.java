public class diameterOfBinaryTree543 {

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */

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


    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;

        int res = subheight(root.right) + subheight(root.left);

        res = Integer.max(res, diameterOfBinaryTree(root.right));
        res = Integer.max(res, diameterOfBinaryTree(root.left));

        return res;

    }

    public int subheight(TreeNode node) {
        if (node == null) {
            return 0;
        }

        return 1 + Integer.max(subheight(node.right), subheight(node.left));

    }



    // official O(N) for both time and space
    int ans;
    public int diameterOfBinaryTree2(TreeNode root) {
        ans = 0;
        depth(root);
        return ans ;
    }
    public int depth(TreeNode node) {
        if (node == null) return 0;
        int L = depth(node.left);
        int R = depth(node.right);
        ans = Math.max(ans, L+R);
        return Math.max(L, R) + 1;
    }
}

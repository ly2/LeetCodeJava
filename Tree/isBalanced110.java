public class isBalanced110 {
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

    public boolean isBalanced(TreeNode root) {
        if(root == null)
            return true;
        if(Math.abs(height(root.left) - height(root.right)) > 1)
            return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }

    public int height(TreeNode root) {
        if(root == null)
            return 0;
        else
            return Math.max(height(root.left), height(root.right)) +1;
    }











    // much smart!
    int count=0;
    public boolean isBalanced2(TreeNode root) {

        if(root == null) return true;

        if(getHeight(root) != Integer.MIN_VALUE)
            return true;
        else
            return false;
    }

    public int getHeight(TreeNode root) {

        if(root == null) return -1;
        // count++;
        // System.out.println("iteration: " + count);

        int lh = getHeight(root.left);
        if(lh == Integer.MIN_VALUE) return Integer.MIN_VALUE;

        int rh = getHeight(root.right);
        if(rh == Integer.MIN_VALUE) return Integer.MIN_VALUE;

        if(Math.abs(lh - rh) > 1) {
            return Integer.MIN_VALUE;
        } else {
            return Math.max(lh, rh) + 1;
        }




    }
}

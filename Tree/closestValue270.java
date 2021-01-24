public class closestValue270 {

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

    // iteration method
    public int closestValue(TreeNode root, double target) {
        if(root == null)
            return Integer.MAX_VALUE;
        TreeNode next = root;
        int closest = root.val;
        while(next != null) {
            if(Math.abs(next.val - target) <= Math.abs(closest - target)) {
                closest = next.val;
            }
            if(target < next.val)
                next = next.left;
            else
                next = next.right;
        }
        return closest;

    }
}

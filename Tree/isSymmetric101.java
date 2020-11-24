public class isSymmetric101 {

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


    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        if (root.left == null && root.right==null)
            return true;
        if (root.left !=null && root.right != null) {
            return preorderP(root.left, true).equals(preorderN(root.right,false));
        }
        return false;
    }

    public String preorderP(TreeNode node, boolean left) {
        if (node==null) {
            if (left)
                return "lnull";
            else
                return "rnull";
        }
        return  " #"+ node.val +" "+preorderP(node.left, true) +  preorderP(node.right, false);
    }
    public String preorderN(TreeNode node, boolean left) {
        if (node==null) {
            if (left)
                return "rnull";
            else
                return "lnull";
        }
        return  " #"+ node.val +" "+preorderN(node.right, false) + preorderN(node.left, true);
    }



    // official
    // why so fool i am ?!!
    public boolean isSymmetric2(TreeNode root) {
        return isMirror(root, root);
    }

    public boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        return (t1.val == t2.val)
                && isMirror(t1.right, t2.left)
                && isMirror(t1.left, t2.right);
    }





}

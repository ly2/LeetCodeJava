public class tree2str606 {
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


    // clean and fast, low runtime memory!
    public String tree2str(TreeNode t) {
        if (t == null) return "";
        StringBuilder sb = new StringBuilder();
        helper(sb, t);
        String res = sb.toString();

        return res.substring(1, res.length() - 1);
    }

    public void helper(StringBuilder sb, TreeNode t) {
        if (t == null) return;
        sb.append('(');
        sb.append(t.val);
        if (t.left == null && t.right != null) sb.append("()");
        helper(sb, t.left);
        helper(sb, t.right);
        sb.append(')');

    }

    // fast!
    StringBuilder sb = new StringBuilder();
    public String tree2str2(TreeNode t) {
        t2s(t);
        return sb.toString();
    }

    public void t2s(TreeNode t) {
        if(t == null) {
            return;
        }
        if(t.left == null && t.right == null) {
            sb.append(t.val);
            return;
        }
        if(t.right == null) {
            sb.append(t.val).append('(');
            t2s(t.left);
            sb.append(')');
            return;
        }

        sb.append(t.val).append('(');
        t2s(t.left);
        sb.append(')').append('(');
        t2s(t.right);
        sb.append(')');
        return;
    }


    // clean!
/*    public String tree2str(TreeNode t) {
        if(t==null)
            return "";
        if(t.left==null && t.right==null)
            return t.val+"";
        if(t.right==null)
            return t.val+"("+tree2str(t.left)+")";
        return t.val+"("+tree2str(t.left)+")("+tree2str(t.right)+")";
    }*/
}

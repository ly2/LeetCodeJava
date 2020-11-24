import java.util.HashSet;

public class isSubtree572 {
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

    class Solution {
        public boolean isSubtree(TreeNode s, TreeNode t) {
            return traverse(s,t);
        }

        public boolean equal(TreeNode a, TreeNode b) {
            if (a == null && b == null) {
                return true;
            }
                if (a != null && b != null && a.val == b.val) {
                    return equal(a.left, b.left) && equal(a.right, b.right);
                }
                return false;

        }

        public boolean traverse(TreeNode a, TreeNode b) {
            if (equal(a, b))
                return true;
            if (a == null)
                return false;
            return traverse(a.left, b) || traverse(a.right, b);
            // better method return  s!=null && ( equals(s,t) || traverse(s.left,t) || traverse(s.right,t));
        }



        HashSet< String > trees = new HashSet < > ();
        public boolean isSubtree2(TreeNode s, TreeNode t) {
            String tree1 = preorder(s, true);
            String tree2 = preorder(t, true);
            return tree1.indexOf(tree2) >= 0;
        }
        public String preorder(TreeNode t, boolean left) {
            if (t == null) {
                if (left)
                    return "lnull";
                else
                    return "rnull";
            }
            return "#"+t.val + " " +preorder(t.left, true)+" " +preorder(t.right, false);
        }
    }
}

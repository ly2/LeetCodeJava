import java.util.Stack;

public class lowestCommonAncestor236 {


//      Definition for a binary tree node.


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return null;

        if (root.equals(p) || root.equals(q))
            return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }

        if (left == null && right == null)
            return null;


        return left != null? left: right;
    }



    // one search for comparing the p and q
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null)
            return null;
        if(root == p || root == q)
            return root;
        TreeNode left = lowestCommonAncestor(root.left,  p,  q);
        TreeNode right = lowestCommonAncestor(root.right,  p,  q);
        if(left != null && right != null)
            return root;
        if(left == null && right == null)
            return null;

        return left!= null?left:right;

    }










    Stack<TreeNode> pstack = new Stack<>();
    Stack<TreeNode> qstack = new Stack<>();



    // slower method
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {


        if (root.val == p.val || root.val == q.val) {
            return root;
        }
        search(root, p.val, true);
        search(root, q.val, false);
        TreeNode ans = pstack.peek();
        while (!pstack.empty() && !qstack.empty()) {
            if (pstack.peek().val == qstack.peek().val) {
                ans = pstack.pop();
                qstack.pop();
            } else {
                break;
            }
        }
        return ans;
    }

    public boolean search(TreeNode node, int val, boolean isp) {
        if (node.val == val) {
            if (isp)
                pstack.push(node);
            else
                qstack.push(node);
            return true;
        }
        if (node.right != null && search(node.right, val, isp)) {
            if (isp)
                pstack.push(node);
            else
                qstack.push(node);
            return true;
        } else if (node.left != null && search(node.left, val, isp)){
            if (isp)
                pstack.push(node);
            else
                qstack.push(node);
            return true;
        }
        return false;
    }
}

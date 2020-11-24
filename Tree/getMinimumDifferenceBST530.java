import java.util.ArrayList;

public class getMinimumDifferenceBST530 {

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




    int ans = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        if (root.left != null) {
            ans = Math.min(ans, root.val-maximum(root.left));
            getMinimumDifference(root.left);
        }
        if (root.right != null) {
            ans = Math.min(ans, minimum(root.right)-root.val);
            getMinimumDifference(root.right);
        }

        return ans;
    }

    public int minimum(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node.val;
    }

    public int maximum(TreeNode node) {
        while (node.right != null)
            node = node.right;
        return node.val;
    }


    // smarter
    private int min;
    private TreeNode prev;
    public int minDiffInBST(TreeNode root) {
        min = Integer.MAX_VALUE;
        inOrder(root);
        return min;
    }
    private void inOrder(TreeNode root){
        if(root==null)return;
        inOrder(root.left);
        min = prev!=null ? Math.min(min,Math.abs(root.val-prev.val)): min;
        prev = root;
        inOrder(root.right);
    }

    // inorder
    public int getMinimumDifference2(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        inOrder(root,list);
        int min = Integer.MAX_VALUE;;
        for(int i=0;i<list.size()-1;i++)
            min = Math.min(min , list.get(i+1)-list.get(i));
        return min;
    }
    private void inOrder(TreeNode root, ArrayList<Integer> list){
        if(root==null)return;
        inOrder(root.left , list);
        list.add(root.val);
        inOrder(root.right,list);
    }
}

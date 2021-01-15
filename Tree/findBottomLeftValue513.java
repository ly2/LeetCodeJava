import java.util.ArrayDeque;
import java.util.Queue;

public class findBottomLeftValue513 {
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


    Queue<TreeNode> queue = new ArrayDeque<>();
    public int findBottomLeftValue(TreeNode root) {


        queue.offer(root);
        bfs();


        return queue.poll().val;
    }


    public void bfs() {
        int size = queue.size();
        int haschild = 0;
        TreeNode ans = queue.element();
        while (size >0) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                queue.offer(node.left);
                haschild++;
            }
            if (node.right != null) {
                queue.offer(node.right);
                haschild++;
            }
            size--;
        }
        if (haschild!= 0)
            bfs();
        else
            queue.offer(ans);
    }

}

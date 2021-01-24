import java.util.LinkedList;
import java.util.Queue;

public class isCousins993 {
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





    // BFS
    public boolean isCousins(TreeNode root, int A, int B) {
        if (root == null) return false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean isAexist = false;
            boolean isBexist = false;
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (cur.val == A) isAexist = true;
                if (cur.val == B) isBexist = true;
                if (cur.left != null && cur.right != null) {
                    if (cur.left.val == A && cur.right.val == B) {
                        return false;
                    }
                    if (cur.left.val == B && cur.right.val == A) {
                        return false;
                    }
                }
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            if (isAexist && isBexist)  return true;
        }
        return false;
    }




    //***********************************************************************************************************************
    TreeNode xParent = null;
    TreeNode yParent = null;
    int xDepth = -1, yDepth = -1;

    // much clean ! and faster!!!  DFS
    public boolean isCousins0(TreeNode root, int x, int y) {
        getDepthAndParent(root, x, y, 0, null);
        return xDepth == yDepth && xParent != yParent? true: false;
    }
    //get both the depth and parent for x and y
    public void getDepthAndParent(TreeNode root, int x, int y, int depth, TreeNode parent){
        if(root == null){
            return;
        }
        if(root.val == x){
            xParent = parent;
            xDepth = depth;
        }else if(root.val == y){
            yParent = parent;
            yDepth = depth;
        }
        getDepthAndParent(root.left, x, y, depth + 1, root);
        getDepthAndParent(root.right, x, y, depth + 1, root);
    }






    //***********************************************************************************************************************
    // very inefficient!!!
    public boolean isCousins1(TreeNode root, int x, int y) {
        int dep_x = 0, dep_y = 0, dep = 1;
        TreeNode p_x = null, p_y = null;
        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(root);
        while(!list.isEmpty()) {
            int l = list.size();
            for(int i = 0; i < l; i++) {
                TreeNode node = list.pollFirst();
                if(node.left != null) {
                    list.add(node.left);
                    if(node.left.val == x) {
                        p_x = node;
                        dep_x = dep;
                    }

                    if(node.left.val == y) {
                        p_y = node;
                        dep_y = dep;
                    }

                }
                if(node.right != null) {
                    list.add(node.right);
                    if(node.right.val == x) {
                        p_x = node;
                        dep_x = dep;
                    }

                    if(node.right.val == y) {
                        p_y = node;
                        dep_y = dep;
                    }

                }
            }
            dep++;
        }

        if(dep_x != dep_y || p_y.equals(p_x) )
            return false;
        return true;
    }





//***********************************************************************************************************************
    // the tree in this question is not a binary search tree, it is just a binary tree.
    // 题目中的树并不符合左小右大的插入规则
    public boolean isCousins2(TreeNode root, int x, int y) {
        int dep_x = 0, dep_y = 0;
        TreeNode node_x = root, node_y = root;
        TreeNode parent_x = null, parent_y = null;
        while( node_x != null && node_x.val != x ) {
            parent_x = node_x;
            if(x < node_x.val)
                node_x = node_x.left;
            else
                node_x = node_x.right;
            dep_x++;
        }
        while(  node_y != null&& node_y.val != y) {
            parent_y = node_y;
            if(y < node_y.val)
                node_y = node_y.left;
            else
                node_y = node_y.right;
            dep_y++;
        }
        if(parent_x.equals(parent_y) || dep_y!= dep_x)
            return false;
        return true;

    }

}

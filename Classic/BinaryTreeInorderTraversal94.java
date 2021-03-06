/*
        94. Binary Tree Inorder Traversal
        Given the root of a binary tree, return the inorder traversal of its nodes' values.

        Follow up: Recursive solution is trivial, could you do it iteratively?
*/

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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



public class BinaryTreeInorderTraversal94 {
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


    public List<Integer> inorderTraversal(TreeNode root) {

//        recursive method
//        List<Integer> nodes1 = new ArrayList<>();
//        if (root==null)
//            return nodes1;
//
//        List<Integer> nodes2 = new ArrayList<>();
//        if (root.left != null) {
//            nodes1 = inorderTraversal(root.left);
//        }
//        if (root.right != null) {
//            nodes2 = inorderTraversal(root.right);
//        }
//
//        nodes1.add(root.val);
//        nodes1.addAll(nodes2);
//        return nodes1;

        List<Integer> inorder = new ArrayList<>();
        if (root==null)
            return inorder;

        if (root.right == null && root.left == null) {
            inorder.add(root.val);
            return inorder;
        }


        List<TreeNode> inordernodes = new ArrayList<>();
        Stack<TreeNode> nodes = new Stack<>();
        if (root.right != null) {
            nodes.push(root.right);
        }
        nodes.push(root);
        if (root.left != null)
            nodes.push(root.left);

        while(!nodes.empty()) {
            TreeNode n = nodes.pop();
            if (n.left==null) {
                inordernodes.add(n);
                if (n.right!= null ) {
                    if (!nodes.empty() &&!n.right.equals(nodes.peek()))
                        nodes.push(n.right);
                    if (nodes.empty())
                        nodes.push(n.right);
                }
            } else if (inordernodes.contains(n.left)){
                inordernodes.add(n);
            } else {
                if (n.right!= null)
                    nodes.push(n.right);
                nodes.push(n);
                if (n.left!= null)
                    nodes.push(n.left);
            }
        }
        for (TreeNode n:inordernodes
             ) {
            inorder.add(n.val);
        }
        return inorder;


/*
//        official solution
        List<Integer> res = new ArrayList < > ();
        Stack < TreeNode > stack = new Stack < > ();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            res.add(curr.val);
            curr = curr.right;
        }
        return res;*/



/*//        Morris traversal
        List < Integer > res = new ArrayList < > ();
        TreeNode curr = root;
        TreeNode pre;
        while (curr != null) {
            if (curr.left == null) {
                res.add(curr.val);
                curr = curr.right; // move to next right node
            } else { // has a left subtree
                pre = curr.left;
                while (pre.right != null) { // find rightmost
                    pre = pre.right;
                }
                pre.right = curr; // put cur after the pre node
                TreeNode temp = curr; // store cur node
                curr = curr.left; // move cur to the top of the new tree
                temp.left = null; // original cur left be null, avoid infinite loops
            }
        }
        return res;*/

    }
}

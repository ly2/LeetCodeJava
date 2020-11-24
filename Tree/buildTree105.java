import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class buildTree105 {
    public static class TreeNode {
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


    public TreeNode buildTree(int[] preorder, int[] inorder) {
//        List inorderlist =  Arrays.asList(inorder);
//        List preorderlist = Arrays.asList(preorder);
        List preorderlist = Arrays.stream(preorder).boxed().collect(Collectors.toList());
        List inorderlist = Arrays.stream(inorder).boxed().collect(Collectors.toList());

        return listbuildtree(preorderlist, inorderlist);
    }

    public TreeNode listbuildtree(List preorder, List inorder) {
        if (preorder.size() == 0)
            return null;
        if (preorder.size() == 1)
            return new TreeNode((Integer) preorder.get(0));


        int rootvalue = (int) preorder.get(0);

        int index = inorder.indexOf(rootvalue);

        List preright = preorder.subList(index+1, preorder.size());
        List preleft = preorder.subList(1, index+1);
        List inright = inorder.subList(index+1, preorder.size());
        List inleft = inorder.subList(0, index);

        TreeNode left = listbuildtree(preleft, inleft);
        TreeNode right = listbuildtree(preright, inright);

        return new TreeNode(rootvalue, left,right);
    }



    // same idea, but don't use the list, just use index
    public TreeNode buildTree2(int[] preorder, int[] inorder) {
        return buildTree(preorder, inorder, 0, inorder.length - 1, 0);
    }

    private TreeNode buildTree(int[] preorder, int[] inorder, int start, int end, int index) {
        if(start > end) return null;
        TreeNode root = new TreeNode(preorder[index]);

        int inIndex = start;
        while(preorder[index] != inorder[inIndex]) inIndex++;

        root.left = buildTree(preorder, inorder, start, inIndex - 1, index + 1);
        root.right = buildTree(preorder, inorder, inIndex + 1, end, index + inIndex - start + 1);

        return root;
    }



    // smartest method
    static int in, pre;
    public static TreeNode buildTree3(int[] preorder, int[] inorder) {
        return buildTree(preorder, inorder, Integer.MAX_VALUE);
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder, int stop) {
//        System.out.println(in);
//        System.out.println(pre);
//        System.out.println();

        if (pre == preorder.length || inorder[in] == stop) {
            in++;
            return null;
        }
        TreeNode node = new TreeNode(preorder[pre++]);
//        System.out.println(node.val);
//        System.out.println();
        node.left = buildTree(preorder, inorder, node.val);
        node.right = buildTree(preorder, inorder, stop);
        return node;
    }


    public static void main(String[] args) {
        buildTree3(new int[]{3,9,20,15,7}, new int[]{9,3,15,20,7});
    }

}

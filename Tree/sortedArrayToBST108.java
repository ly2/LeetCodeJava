import java.util.Arrays;

public class sortedArrayToBST108 {
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

    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0)
            return null;
        int idx = nums.length / 2;
        TreeNode root = new TreeNode(nums[idx]);
        if(idx > 0)
            root.left = sortedArrayToBST(Arrays.copyOfRange(nums, 0, idx));
        if(idx < nums.length-1)
            root.right = sortedArrayToBST(Arrays.copyOfRange(nums, idx+1, nums.length));
        return root;
    }



    // same idea another method!
    public TreeNode sortedArrayToBST2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        return helper(nums, 0, nums.length-1);
    }

    private TreeNode helper(int[] nums, int start, int end) {
        if (start == end) {
            return new TreeNode(nums[start]);
        } else if (start > end) {
            return null;
        }

        int mid = start + (end-start)/2;
        TreeNode curr = new TreeNode(nums[mid]);
        curr.left = helper(nums, start, mid-1);
        curr.right = helper(nums, mid+1, end);

        return curr;
    }
}

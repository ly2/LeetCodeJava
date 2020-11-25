public class searchInsert35 {

    public int searchInsert(int[] nums, int target) {
        if (nums.length == 0)
            return 0;
        return subsearch(nums,target,0, nums.length);
    }

    public int subsearch (int[] nums, int target, int start, int end) {
        if ( start == end)
            return end;
        int median = (start+end)/2;
        if (nums[median] == target)
            return median;
        else if (nums[median] > target) {
            return subsearch(nums,target, start, median);
        } else {
            return subsearch(nums,target,median+1, end);
        }
    }
}

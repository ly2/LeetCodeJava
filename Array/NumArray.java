class NumArray {

    private int[] arr;
    public NumArray(int[] nums) {
        this.arr = new int[nums.length +1];
        for(int i = 1; i < arr.length; i++) {
            arr[i] = arr[i-1] + nums[i-1];
        }
    }

    public int sumRange(int i, int j) {
        return arr[j+1]-arr[i];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */
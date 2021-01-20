import java.util.Arrays;

public class pivotIndex724 {



    public int pivotIndex2(int[] nums) {
        if (nums.length <3)
            return -1;
        for (int i = 1; i < nums.length;i++) {
            nums[i] += nums[i-1];
        }
        int idx = nums.length-1;

        if (nums[idx] - nums[0] == 0)
            return 0;
        for (int i = 1; i < nums.length-1;i++) {
            if (nums[i-1] == nums[idx]-nums[i])
                return i;
        }
        if (nums[idx-1] == 0)
            return nums.length-1;
        return -1;
    }



    // simplify!!!
    public int pivotIndex(int[] nums) {
        int fromRight=0;
        for(int i=nums.length-1;i>-1;i--){
            fromRight+=nums[i];
        }
        int acc=0;
        for(int i=0;i<nums.length;i++){
            fromRight-=nums[i];
            if(acc==fromRight)
                return i;
            acc+=nums[i];
        }
        return -1;

    }
}

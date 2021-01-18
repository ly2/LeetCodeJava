import java.util.HashSet;

public class minMoves453 {

    public int minMoves(int[] nums) {


        int ans = 0;
        int min = nums[0];
        for (int n : nums) {
            ans += n;
            min = Math.min(min, n);
        }



        return ans - min*nums.length;

//        int min = nums[0];
//        for (int n : nums) {
//            min = Math.min(min, n);
//        }
//
//        int ans = 0;
//        for (int n : nums) {
//            ans += n-min;
//        }
//        return ans;
    }

}

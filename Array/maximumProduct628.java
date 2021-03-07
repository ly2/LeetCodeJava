import java.util.Arrays;


public class maximumProduct628 {

    public int maximumProduct(int[] nums) {
        if (nums.length == 3)
            return nums[0]*nums[1]*nums[2];

//        int p = 0, n = 0;
//        for (int num : nums) {
//            if (num >= 0 )
//                p++;
//            else
//                n++;
//        }
//        Arrays.sort(nums);
//        if (n == 0 ||n == 1|| p == 0) {
//            return nums[nums.length-1]*nums[nums.length-2]*nums[nums.length-3];
//        } else if (p == 1) {
//            return nums[nums.length-1]*nums[0]*nums[1];
//        } else if (n == 2) {
//            return Math.max( nums[nums.length-1]*nums[0]*nums[1], nums[nums.length-1]*nums[nums.length-2]*nums[nums.length-3]);
//        } else if (p == 2) {
//            return Math.max( nums[nums.length-1]*nums[0]*nums[1], nums[0]*nums[nums.length-1]*nums[nums.length-2]);
//        }

        Arrays.sort(nums);
        int maxP = Integer.MIN_VALUE;
        maxP = Math.max(maxP,  nums[0]*nums[1]*nums[nums.length-1]);
        maxP = Math.max(maxP,  nums[nums.length-1]*nums[nums.length-2]*nums[nums.length-3]);

        return maxP;
    }


    // submission method! as we just need to cal the max 3 and min 2, so we just found them by one scan!
    public int maximumProduct1(int[] nums) {
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
        for (int n: nums) {
            if (n <= min1) {
                min2 = min1;
                min1 = n;
            } else if (n <= min2) {     // n lies between min1 and min2
                min2 = n;
            }
            if (n >= max1) {            // n is greater than max1, max2 and max3
                max3 = max2;
                max2 = max1;
                max1 = n;
            } else if (n >= max2) {     // n lies betweeen max1 and max2
                max3 = max2;
                max2 = n;
            } else if (n >= max3) {     // n lies betwen max2 and max3
                max3 = n;
            }
        }
        return Math.max(min1 * min2 * max1, max1 * max2 * max3);
    }
}

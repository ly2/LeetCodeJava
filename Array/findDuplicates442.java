import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
 *
 * Find all the elements that appear twice in this array.
 *
 * Could you do it without extra space and in O(n) runtime?
 */
public class findDuplicates442 {

    public List<Integer> findDuplicates(int[] nums) {


//        Runtime: 16 ms, faster than 31.06% of Java online submissions for Find All Duplicates in an Array.
//        Memory Usage: 49 MB, less than 48.18% of Java online submissions for Find All Duplicates in an Array.

        List<Integer> res = new ArrayList<>();
        if (nums.length==0)
            return res;
        Arrays.sort(nums);

        int current = nums[0];

        for (int i=1; i < nums.length;i++) {
            if (current==nums[i]) {
                res.add(current);
                i++;
                while (i < nums.length && nums[i] == current)
                    i++;
                if (i < nums.length)
                    current = nums[i];
            } else {
                current = nums[i];
            }
        }

        return res;


    }

//  // or use a new array
    //3ms
    //49.1mb
//  public List<Integer> findDuplicates(int[] nums) {
//      ArrayList<Integer> list =new ArrayList<Integer>();
//      int[] arr=new int[nums.length+1];
//
//      for(int i=0;i<nums.length;i++)
//      {
//          arr[nums[i]]++;
//      }
//
//      for(int i=0;i<nums.length;i++)
//      {
//          if(arr[nums[i]]==2)
//          {
//              list.add(nums[i]);
//              arr[nums[i]]=-1;
//
//          }
//      }
//      return list;
//  }




////    Should read question firstly
//    public List<Integer> findDuplicates(int[] nums) {
//        int length = nums.length;
//        List<Integer> result = new ArrayList<>(length);
//        Arrays.sort(nums);
//        for (int i = 1; i < length; i++) {
//            if (nums[i] == nums[i-1]) result.add(nums[i]);
//        }
//        return result;
//    }
}

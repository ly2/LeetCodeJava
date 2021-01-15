import java.util.*;

public class intersection349 {

    // crazy!!!
    public int[] intersection(int[] nums1, int[] nums2) {
        int[] markers = new int [1000];

        for (int val: nums1) {
            markers[val] = 1;
        }

        int[] result = new int [Math.max(nums1.length, nums2.length)];
        int position = 0;
        for (int val: nums2) {
            if(markers[val] == 1) {
                result[position++] = val;
                markers[val] = 0;
            }
        }

        return Arrays.copyOfRange(result, 0, position);

    }

    // if Sorted: O(n) time and O(1) space
    public int[] intersection1(int[] nums1, int[] nums2) {
        //inputs are sorted as assumed
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        //output is not considered in space
        List<Integer> list = new ArrayList<>();
        int i = 0;
        int j = 0;
        int k = 0;

        while(i < nums1.length && j < nums2.length) {
            //both skip duplicates
            while(i > 0 && i < nums1.length && nums1[i] == nums1[i - 1]) i++;
            while(j > 0 && j < nums2.length && nums2[j] == nums2[j - 1]) j++;

            //when still valid
            if(i < nums1.length && j < nums2.length) {
                if(nums1[i] == nums2[j]) {
                    nums1[k++] = nums1[i++];
                    j++;
                }else if(nums1[i] < nums2[j]) {
                    i++;
                }else {
                    j++;
                }
            }
        }

        return Arrays.copyOf(nums1, k);
    }





    public int[] intersection2(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();

        for (int num : nums1) {
            set.add(num);
        }

        HashSet<Integer> anset = new HashSet<>();


        for (int num : nums2) {
            if (set.contains(num)) {
                anset.add(num);
            }
        }

        int[] ans = new int[anset.size()];
        int i = 0;
        for (int n : anset) {
            ans[i] = n;
            i++;
        }
        return ans;
    }
}

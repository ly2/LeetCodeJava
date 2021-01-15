import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class intersect350 {


    //4 ms	39.2 MB
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();

        ArrayList<Integer> list = new ArrayList<>();
        for (int n : nums1) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        for (int n : nums2) {

            int cnt = map.getOrDefault(n, 0);
            if (cnt > 0 ) {
                map.put(n, map.get(n)-1);
                list.add(n);
            }

        }


        return list.stream().mapToInt(Integer::intValue).toArray();
    }


    //2 ms	39.1 MB faster!
    public int[] intersect2(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }
        HashMap<Integer, Integer> m = new HashMap<>();
        for (int n : nums1) {
            m.put(n, m.getOrDefault(n, 0) + 1);
        }
        int k = 0;
        for (int n : nums2) {
            int cnt = m.getOrDefault(n, 0);
            if (cnt > 0) {
                // faster!
                nums1[k++] = n;
                //
                m.put(n, cnt - 1);
            }
        }
        //
        return Arrays.copyOfRange(nums1, 0, k);
        //
    }
}

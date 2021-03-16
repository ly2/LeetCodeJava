import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class arrayRankTransform1331 {


    // original
    public int[] arrayRankTransform1(int[] arr) {
        int[] new_arr = arr.clone();
        HashMap<Integer, Integer> map = new HashMap<>();

        Arrays.sort(new_arr);
        int order = 1;
        for (int num : new_arr) {
            if (map.getOrDefault(num, -1) == -1) {
                map.put(num, order);
                order++;
            }
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = map.get(arr[i]);
        }
        return res;
    }


    // tricky!
    // find the min and max value in the arr and then build a max-min+1 arr to store the occurence.
    // use the index to distribute the order for them
    // 3ms
    public int[] arrayRankTransform(int[] arr) {
        int minVal = Integer.MAX_VALUE;
        int maxVal = Integer.MIN_VALUE;
        for (int num: arr) {
            if (minVal > num) {
                minVal = num;
            }
            if (maxVal < num) {
                maxVal = num;
            }
        }
        int[] rank = new int[maxVal-minVal+1];
        for (int num: arr) {
            rank[num-minVal] = 1;
        }
        int sum = 1;
        for (int i = 0; i < rank.length; i++) {
            if (rank[i] != 0) {
                rank[i] = sum;
                sum++;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rank[arr[i]-minVal];
        }
        return arr;
    }
}

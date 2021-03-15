import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class minimumAbsDifference1200 {


    //13 ms
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);

        int min_abs = Integer.MAX_VALUE;

        for (int i = 0 ; i < arr.length-1; i++) {
//            int abs = arr[i+1]-arr[i];
            if ( arr[i+1]-arr[i] < min_abs)
                min_abs = arr[i+1]-arr[i];
        }
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < arr.length-1; i++) {
//            int abs = arr[i+1]-arr[i];
            if ( arr[i+1]-arr[i] == min_abs) {
                int finalI = i;
//                res.add(new ArrayList<Integer>(){{
//                    add(arr[finalI]);
//                    add(arr[finalI +1]);
//                }});
                List<Integer> l = new ArrayList<>();
                l.add(arr[i]);
                l.add(arr[i+1]);
                res.add(l);
            }
        }
        return res;
    }

    // beat 100% 10ms
    // don't use the sort
    public List<List<Integer>> minimumAbsDifference2(int[] arr) {

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i =0; i < arr.length; i++){
            min = Math.min(arr[i], min);
            max = Math.max(arr[i], max);
        }
        boolean[] bucket = new boolean[max - min +1];
        for(int i =0; i< arr.length; i++){
            bucket[arr[i]- min] = true;
        }
        List<List<Integer>> list = new ArrayList();
        int delta = Integer.MAX_VALUE;
        int pre = -1;
        for(int i =0; i< bucket.length; i++){
            if(bucket[i]){
                if(pre!=-1){
                    int t = i- pre;
                    if(t ==delta){
                        list.add(Arrays.asList(pre+min, i+min));
                    }else if (t < delta){
                        list.clear();
                        list.add(Arrays.asList(pre+min, i+min));
                        delta = t;
                    }
                }
                pre =i;
            }

        }
        return list;
    }
}

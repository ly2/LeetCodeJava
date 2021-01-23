import java.util.*;

public class highFive1086 {


    public int[][] highFive(int[][] items) {

        HashMap<Integer, PriorityQueue<Integer>> map = new HashMap<>();

        for (int[] stu : items) {
            if (map.getOrDefault(stu[0], null)==null) {
                map.put(stu[0], new PriorityQueue<>());
                map.get(stu[0]).offer(stu[1]);

            } else {
                Queue<Integer> queue = map.get(stu[0]);
                queue.offer(stu[1]);
                if (queue.size() > 5)
                    queue.poll();
            }
        }

        int[][] ans = new int[map.size()][2];
        int i = 0;
        for (int id : map.keySet()) {
            ans[i][0] = id;
            Queue<Integer> queue = map.get(id);
            int sum = 0;
            while (!queue.isEmpty()) {
                sum += queue.poll();
            }
            ans[i++][1] = sum/5;
        }
        Arrays.sort(ans, (a,b) -> Integer.compare(a[0], b[0]));
        return ans;
    }



    // do not used the hash map so that don't need to sort the ans
    public int[][] highFive2(int[][] items) {

        int[][] students = new int[1001][] ;

        for(int[] item : items) {

            if (students[item[0]] == null) {
                students[item[0]] = new int[5];
            }
            int[] scores = students[item[0]];
            int s = item[1];
            for(int i = 0; i<5; i++) {
                if (s >= scores[i]) {
                    if (i>0) scores[i-1] = scores[i];
                    scores[i] = s;
                } else {
                    break;
                }
            }


        }

        List<int[]> res = new ArrayList<>();

        for(int i = 0; i< 1001; i++) {
            if (students[i] == null) {
                continue;
            }
            int[] scores = students[i];
            int sum = 0;
            for(int x : scores) {
                sum+=x;
            }
            res.add(new int[] {i, sum/5});
        }

        return res.toArray(new int[0][0]);


    }
}

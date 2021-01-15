import java.util.PriorityQueue;

public class kthSmallestPrimeFraction786 {


    // 2分
    public int[] kthSmallestPrimeFraction2(int[] A, int K) {
        double left = 0.0, right = 1.0;
        int n = A.length;
        while(left < right) {
            double mid = (right + left) / 2;
            int count = 0;
            double max = 0;
            int p = 0, q = 0;
            int j = 1;
            for(int i = 0; i < n - 1; i++) {
                while(j < n && (1.0 * A[i] / A[j]) > mid) j++;
                count += (n - j);
                if(j == n) break;
                double f = 1.0 *A[i]/ A[j];
                if(max < f) {
                    max = f;
                    p = i;
                    q= j;
                }
            }
            if(count == K) {
                return new int[]{A[p], A[q]};
            }
            else if(count > K) {
                right = mid;
            }
            else {
                left = mid;
            }
        }
        return new int[]{};
    }

    // heap
    public int[] kthSmallestPrimeFraction(int[] A, int K) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) ->
                A[a[0]] * A[b[1]] - A[a[1]] * A[b[0]]);

        for (int i = 1; i < A.length; ++i)
            pq.add(new int[]{0, i});


        while (--K > 0) {
            int[] frac = pq.poll();
            if (frac[0]++ < frac[1])
                pq.offer(frac);
        }

        int[] ans = pq.poll();
        return new int[]{A[ans[0]], A[ans[1]]};
    }
}

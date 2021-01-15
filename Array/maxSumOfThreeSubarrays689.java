public class maxSumOfThreeSubarrays689 {


    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {

        int n = nums.length;
        int[] sum = new int[n+1], left = new int[n], right = new int[n], ans = new int[3];

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n;i++)
            sum[i+1] = nums[i] + sum[i];

        // cal left
        for (int i = k,total = sum[k] - sum[0]; i < n; i++) {
            if (sum[i+1]-sum[i-k+1] > total) {
                left[i] = i-k+1;
                total = sum[i+1]-sum[i-k+1];
            } else
                left[i] = left[i-1];
        }


        // cal right
        right[n-k] = n-k;
        for (int i = n-k-1,total = sum[n] - sum[n-k]; i >= 0; i--) {
            if (sum[i+k]-sum[i] >= total) {
                right[i] = i;
                total = sum[i+k]-sum[i];
            } else
                right[i] = right[i+1];
        }

        // cal mid

        for (int i = k; i <= n - 2*k; i++ ) {
            int l = left[i-1], r = right[i+k];
            // total = left + right + mid
            int total = sum[l+k]-sum[l] + sum[r+k] - sum[r] + sum[i+k] - sum[i];
            if (total > max) {
                max = total;
                ans[0] = l;
                ans[1] = i;
                ans[2] = r;
            }
        }
        return ans;
    }
}

public class maxSumTwoNoOverlap1031 {


    public int maxSumTwoNoOverlap(int[] A, int L, int M) {
        int n=A.length;
        for(int i=1;i<n;i++)
            A[i]+=A[i-1];


        int ans=A[L+M-1];
        int lmax=A[L-1];
        int mmax=A[M-1];



        for(int i=L+M;i<n;i++){
            lmax=Math.max(lmax,A[i-M]-A[i-L-M]);
            mmax=Math.max(mmax,A[i-L]-A[i-L-M]);
            ans=Math.max(ans,Math.max(lmax+A[i]-A[i-M],mmax+A[i]-A[i-L]));
        }
        return ans;
    }


    //original  5 ms	39.1 MB
    public int maxSumTwoNoOverlap2(int[] A, int L, int M) {
        int larr_len = Math.max(L, M);
        int sarr_len = Math.min(L, M);

        int[] presum = new int[A.length];
        presum[0] = A[0];
        for (int i = 1; i < A.length; i++) {
            presum[i] = presum[i-1]+ A[i];
        }
        int max = Integer.MIN_VALUE;
        int sumL = 0;
        int sumS = 0;
        for (int i = larr_len-1; i < A.length; i++) {

            if ( i-larr_len < 0)
                sumL = presum[i];
            else
                sumL = presum[i] - presum[i-larr_len];



            for (int j = sarr_len-1; j < A.length; j++) {
                if ( (i-larr_len<=j && j<= i)||((i-larr_len<=j-sarr_len+1 && j-sarr_len+1 <= i)) )
                    continue;
                if ( j-sarr_len < 0)
                    sumS = presum[j];
                else
                    sumS = presum[j] - presum[j-sarr_len];

                max = Math.max(max, sumL+sumS);
            }
        }


        return max;
    }
}

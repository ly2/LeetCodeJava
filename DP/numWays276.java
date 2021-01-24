public class numWays276 {

    public int numWays(int n, int k) {
        if(n == 0)
            return 0;
        if(n == 1)
            return k;
        int prev = k*k;
        int prev2 = k;
        for(int i = 3; i <= n; i++) {
            int tmp = (prev+prev2)*(k-1);
            prev2 = prev;
            prev = tmp;
        }
        return prev;
    }
}

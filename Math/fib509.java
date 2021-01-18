public class fib509 {
    public int fib(int n) {

        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        int tmp = 0, prev = 1, cur = 1;
        for (int i = 3; i <= n; i++) {
            tmp = cur;
            cur = cur+prev;
            prev = tmp;
        }




        return cur;
    }
}

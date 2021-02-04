public class rotatedDigits788 {

    // can use dp
    public int rotatedDigits(int N) {


        return 0;
    }

    public int rotatedDigits2(int N) {
        int count = 0;
        for (int i = 1; i <= N; i++) {
            if (isgood(i)) {
                count++;
            }
        }
        return count;
    }

    public boolean isgood(int n) {
        boolean flag = false;

        while (n != 0) {
            int d = n%10;
            if (d == 3 || d == 4 || d == 7)
                return false;
            if (d == 2 || d == 5 || d == 6 || d == 9)
                flag = true;
            n /= 10;
        }
        return flag;
    }
}

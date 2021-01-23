import java.util.ArrayList;
import java.util.List;

public class countPrimes204 {

    // time limit exceed
    public int countPrimes2(int n) {
        if (n < 2)
            return 0;

        if (n == 2)
            return 1;

        ArrayList<Integer> list = new ArrayList<>();
        list.add(2);

        for (int i = 3; i < n; i++) {
            if (!divisable(i, list))
                list.add(i);
        }
        return list.size();
    }

    public boolean divisable(int n, ArrayList<Integer> list) {
        for (int p : list) {
            if (n%p == 0)
                return true;
        }
        return false;
    }


    // crazy!
    public int countPrimes(int n) {
        if (n <3)
            return 0;
        boolean[] isPrime = new boolean[n];
        for (int i = 2; i < n; i++) {
            isPrime[i] = true;
        }
        // Loop's ending condition is i * i < n instead of i < sqrt(n)
        // to avoid repeatedly calling an expensive function sqrt().
        for (int i = 2; i * i < n; i++) {
            if (!isPrime[i]) continue;
            for (int j = i * i; j < n; j += i) {
                isPrime[j] = false;
            }
        }
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) count++;
        }
        return count;
    }
}

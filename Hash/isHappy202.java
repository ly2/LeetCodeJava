import java.util.HashMap;

public class isHappy202 {

    public boolean isHappy(int n) {
        if (n == 1)
            return true;

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(n,1);
        n = cal(n);
        while (true) {
            if (n == 1)
                return true;
            if (map.getOrDefault(n, 0) != 0)
                return false;
            else {
                map.put(n, 1);
                n = cal(n);
            }

        }
    }


    public int cal(int n) {
        int ans = 0;
        while (n != 0) {
            ans += Math.pow(n%10, 2);
            n /= 10;
        }
        return ans;
    }


    public int sqSum(int n){
        int ans = 0;
        while(n!=0){
            int temp = n%10;
            ans += temp*temp;
            n /= 10;
        }
        return ans;
    }

    // 0 ms	35.7 MB
    // the first boolean is used to avoid termination of the first iteration
    // slow and fast is uesed to iteration the cycle fast!
    //
    public boolean isHappy2(int n) {
        int slow = n, fast = n;
        boolean first = true;
        while(slow != fast || first==true){
            first = false;
            slow = sqSum(slow);
            fast = sqSum(fast);
            fast = sqSum(fast);

        }
        if(slow == 1) return true;
        return false;
    }
}

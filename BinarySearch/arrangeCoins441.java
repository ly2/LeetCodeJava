public class arrangeCoins441 {

    public int arrangeCoins(int n) {
        if (n == 0)
            return 0;
        if (n==1)
            return 1;

        // arithmetic sequence:  get  sum formula
        long right = (long) Math.sqrt(n)*2 +1;
        long left = 0, mid = 0;
        while (left < right) {
            mid = left + (right-left)/2;


            if(( mid*(mid+1)/2) <= n) {
                left = mid+1;
            } else {
                right = mid;
            }

        }

        if ((mid + mid*(mid-1)/2) > n)
            return (int)mid-1;
        return (int)mid;
    }
}

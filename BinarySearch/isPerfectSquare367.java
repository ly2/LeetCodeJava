public class isPerfectSquare367 {

    public boolean isPerfectSquare(int num) {

        int right = (int) Math.sqrt(num)+1;
        int left =1, mid = 0;

        while (left < right) {
            mid = left + (right-left)/2;
            if (mid*mid == num)
                return true;

            if (mid*mid <= num)
                left = mid+1;
            else
                right = mid;
        }

        return false;
    }

}

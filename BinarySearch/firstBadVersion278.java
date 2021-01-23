public class firstBadVersion278 {
    /* The isBadVersion API is defined in the parent class VersionControl.
          boolean isBadVersion(int version); */

    boolean isBadVersion(int i) {
        return false;
    }

    public int firstBadVersion(int n) {
        int left = 1, right = n;
        while (right > left) {
            int mid = left + (right-left)/2;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid+1;
            }
        }

        return left;
    }
}

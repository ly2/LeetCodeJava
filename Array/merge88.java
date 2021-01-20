public class merge88 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int idx = nums1.length-1;
        m--;
        n--;
        while (n >= 0 && m >= 0) {

                if (nums1[m] <= nums2[n]) {
                    nums1[idx--] = nums2[n--];
                } else {
                    nums1[idx--] = nums1[m--];
                }
        }

        while (n >= 0) {
            nums1[idx--] = nums2[n--];
        }

    }
}

public class findKthPositive1539 {

    public int findKthPositive(int[] arr, int k) {
        int count = 0;
        int idx = 0;
        int i = 1;
        while (count != k ) {
            if (idx >= arr.length || arr[idx] != i) {
                count++;
            } else {
                idx++;
            }
            i++;
        }
        return i-1;
    }
}

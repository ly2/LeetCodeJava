public class countBinarySubstrings696 {

    // one more try
    public int countBinarySubstrings(String s) {
        char[] arr = s.toCharArray();
        int count = 0;
        for (int i = 0; i < arr.length-1; i++) {
            if (arr[i] != arr[i+1]) {
                count += countBS(arr, i);
            }
        }
        return count;
    }

    public int countBS(char[] arr, int index) {
        int count = 1, end = index+1;
        while (index > 0 && end < arr.length-1) {
            if (arr[index-1] == arr[index] && arr[end+1] == arr[end]) {
                count++;
                index--;
                end++;
            } else {
                return count;
            }
        }
        return count;
    }
}

public class reverseString344 {
    public void reverseString(char[] s) {
        int left = 0, right = s.length-1;
        char c;
        while (right > left) {
            c = s[right];
            s[right] = s[left];
            s[left] = c;
            right--;
            left++;
        }
    }
}

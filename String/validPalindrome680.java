public class validPalindrome680 {

    public boolean validPalindrome(String s) {


        int left = 0, right = s.length()-1;

        while (right >= left) {
            if (s.charAt(left) != s.charAt(right)) {
                return ispalindrome(s, left+1, right) || ispalindrome(s, left, right-1);
            }
            right--;
            left++;


        }

        return true;
    }

    public boolean ispalindrome(String s, int start, int end) {
        int left = start, right = end;
        while (right >= left) {
            if (s.charAt(left) != s.charAt(right))
                return false;
            right--;
            left++;
        }
        return true;
    }
}

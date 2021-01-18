public class isPalindrome125 {

    // 3 ms	39.3 MB
    public boolean isPalindrome(String s) {
        int left = 0, right = s.length()-1;

        while (left < right) {
            while (left < s.length() && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            while (right >= 0 && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }
            if (left >= right)
                return true;

            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right)))
                return false;
            left++;
            right--;

        }


        return true;
    }



    // 2 ms	38.8 MB
    public boolean isPalindrome2(String s) {
        int start = 0;
        int end = s.length() - 1;

        while(start < end) {
            int startChar = getSmallChar(s.charAt(start));
            int endChar = getSmallChar(s.charAt(end));
            if (startChar == -1) {
                start++;
                continue;
            }
            if (endChar == -1) {
                end--;
                continue;
            }
            if (startChar != endChar) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }

    private int getSmallChar(char c) {
        if (c >= '0' && c <= '9')
            return c;
        if (c >= 'A' && c <= 'Z')
            return c;
        if (c >= 'a' && c <= 'z')
            return c - 32;
        return -1;
    }
}

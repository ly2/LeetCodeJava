public class longestPalindrome409 {


    public int longestPalindrome(String s) {
        int[] chs = new int[58];
        for(char c : s.toCharArray()) {
            chs[c-'A']++;
        }
        int len = 0;

        for(int c : chs ) {
            if(c%2 == 0 ) {
                len += c;
            } else {
                len += c-1;

            }
        }
        return len < s.length() ? len+1: len;
    }
}

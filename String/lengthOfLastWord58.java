public class lengthOfLastWord58 {
    public int lengthOfLastWord(String s) {
        boolean start = false;
        char[] chs = s.toCharArray();
        int count = 0;
        for (int i = chs.length-1; i >= 0; i--) {
            if (chs[i] != ' ') {
                    start = true;
                    count++;

            } else {
                if (start) {
                    return count;
                }
            }
        }
        return 0;
    }



    // much clean
    public int lengthOfLastWord2(String s) {
        // trim the trailing spaces
        int p = s.length() - 1;
        while (p >= 0 && s.charAt(p) == ' ') {
            p--;
        }

        // compute the length of last word
        int length = 0;
        while (p >= 0 && s.charAt(p) != ' ') {
            p--;
            length++;
        }
        return length;
    }
}

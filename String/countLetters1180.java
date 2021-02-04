public class countLetters1180 {

    public int countLetters(String S) {

        char[] chs = S.toCharArray();
        int count = 0,  i = 0, c= 1;

        while (i < chs.length) {
            if (i == chs.length-1 || chs[i+1] != chs[i] ) {
                count += c*(c+1)/2;
                c = 0;
            }
            c++;
            i++;

        }

        return count;
    }



    // dp
    public int countLetters2(String S) {
        int substrings[] = new int[S.length()];
        int total = 1;
        substrings[0] = 1;
        for (int i = 1; i < S.length(); i++) {
            if (S.charAt(i) == S.charAt(i - 1)) {
                substrings[i] = substrings[i - 1] + 1;
            } else {
                substrings[i] = 1;
            }
            total += substrings[i];
        }
        return total;
    }
}

public class freqAlphabets1309 {


    public String freqAlphabets(String s) {
        int prev2 = 0, prev = 1, i = 2;
        StringBuilder sb = new StringBuilder();
        while (i < s.length()) {
            if (s.charAt(i) == '#') {
                sb.append( (char) (Integer.valueOf(s.substring(prev2, i)) -1 + 'a' ) );
                prev2 += 3;
                prev += 3;
                i += 3;
            } else {
                sb.append((char) (s.charAt(prev2)-'1' + 'a'));
                prev2 = prev;
                prev = i;
                i++;
            }
        }

        if (prev2 < s.length())
            sb.append((char) (s.charAt(prev2)-'1' + 'a'));
        if (prev < s.length())
            sb.append((char) (s.charAt(prev)-'1' + 'a'));

        return sb.toString();
    }


    // submission method! much clean!
    public String freqAlphabets2(String s) {
        StringBuilder sb = new StringBuilder();
        int len = s.length();
        for(int i = 0; i < len; i++) {
            if(i < len - 2 && s.charAt(i + 2) == '#') {
                sb.append((char)('j' + (s.charAt(i) - '1') * 10 + (s.charAt(i + 1) - '0')));
                i += 2;
            }
            else {
                sb.append((char)('a' + (s.charAt(i) - '1')));
            }
        }
        return sb.toString();
    }
}

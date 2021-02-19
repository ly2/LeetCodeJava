public class maxPower1446 {

    public int maxPower(String s) {
//        char[] chs = s.toCharArray();
//        int pow = 0, count = 0;
//        for (int i = 0; i < chs.length; i++) {
//            count++;
//            if (i == chs.length - 1 || chs[i] != chs[i+1]) {
//                pow = Math.max(pow, count);
//                count = 0;
//            }
//        }
//        return pow;

        // less runtime memory!
        int pow = 0, count = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            count++;
            if (i == s.length() - 1 || c != s.charAt(i+1)) {
                pow = Math.max(pow, count);
                count = 0;
            }
        }
        return pow;
    }


    // quite simple
    public int maxPower2(String s) {
        int max = 1;
        for(int i = 1, temp = 1; i < s.length(); i++) {
            if(s.charAt(i) == s.charAt(i-1)) max = Math.max(max, ++temp);
            else temp = 1;
        }
        return max;
    }
}

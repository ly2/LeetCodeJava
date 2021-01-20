public class countAndSay38 {

    public String countAndSay(int n) {
        if (n == 1)
            return "1";
        if (n == 2)
            return "11";
        String ans = "11";
        while (--n >1) {
            ans = convert(ans);

        }



        return ans;
    }

    public String convert(String s) {
        char[] chs = s.toCharArray();
        char ch = chs[0];
        int count = 1;
        StringBuilder sb2 = new StringBuilder();
        for (int i = 1; i < chs.length; i++) {

            if (chs[i] == ch) {
                count++;
            } else {
                sb2.append(count).append(ch);
                ch = chs[i];
                count = 1;
            }
        }
        sb2.append(count).append(ch);
        return sb2.toString();
    }


}

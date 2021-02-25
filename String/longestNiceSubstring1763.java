public class longestNiceSubstring1763 {

    // 1ms
    public String longestNiceSubstring(String s) {
        if (s.length() <2)
            return "";
        int[] arr = new int[s.length()];

        boolean isNice = true;
        String ans = "";
        for (char c = 'a', c2 = 'A'; c <= 'z'; c++, c2++) {
            int idx1 = s.indexOf(c);
            int idx2 = s.indexOf(c2);
            if (idx1==-1 && idx2 != -1) {
                arr[idx2] = 1;
            } else if (idx2 == -1 && idx1 != -1) {
                arr[idx1] = 1;
            }
        }

        int prev = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                isNice = false;
                if (i - prev > 2) {
                    String tmp = longestNiceSubstring(s.substring(prev + 1, i));
                    if (tmp.length() > ans.length()) {
                        ans = tmp;
                    }
                }
                prev = i;
            }
        }
        if (s.length() - prev >2 && prev != -1) {
            String tmp = longestNiceSubstring(s.substring(prev + 1));
            if (tmp.length() > ans.length()) {
                ans = tmp;
            }
        }

        if (isNice)
            return s;

        return ans;
    }


    // submission method! 7ms
    public String longestNiceSubstring2(String s) {
        int n = s.length();
        int[] ans = new int[]{-1, -2};
        for (int i = 0; i < n; i++) {
            int lower = 0;
            int upper = 0;
            for (int j = i; j < n; j++) {
                char c = s.charAt(j);
                if (c >= 'a' && c <= 'z') lower |= 1 << (c - 'a');
                else upper |= 1 << (c - 'A');
                int diff = Integer.bitCount(lower ^ upper);
                if (diff == 0 && j - i > ans[1] - ans[0]) {
                    ans[0] = i;
                    ans[1] = j;
                }
            }
        }
        return ans[0] == -1 ? "" : s.substring(ans[0], ans[1]+1);
    }
}

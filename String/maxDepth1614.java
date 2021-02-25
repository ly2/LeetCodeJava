public class maxDepth1614 {

    public int maxDepth(String s) {
        if (s.isEmpty())
            return 0;

        int left_P = 0;
        int ans = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                left_P++;
                ans = Math.max(ans, left_P);
            }
            if (c == ')')
                left_P--;

        }

//        for (int i = 0; i < s.length(); i++) {
//            if (s.charAt(i) == '(') {
//                left_P++;
//            }
//            if (s.charAt(i) == ')') {
//                ans = Math.max(ans, left_P);
//                left_P--;
//            }
//        }
        return ans;
    }
}

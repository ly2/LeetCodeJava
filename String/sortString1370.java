public class sortString1370 {

    public String sortString(String s) {
        int[] chars = new int[26];
        for (char c : s.toCharArray()) {
            chars[c-'a']++;
        }
        StringBuilder sb = new StringBuilder();
        int count = 0;
        while (count < s.length()) {
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] > 0) {
                    chars[i]--;
                    sb.append((char)('a' + i));
                    count++;
                }
            }
            for (int i = chars.length-1; i >=0; i--) {
                if (chars[i] > 0) {
                    chars[i]--;
                    sb.append((char)('a' + i));
                    count++;
                }
            }


        }

        return sb.toString();
    }
}

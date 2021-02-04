public class toGoatLatin824 {

    public String toGoatLatin(String S) {
        StringBuilder sb = new StringBuilder();
        int suffix = 0;
        String[] strs = S.split(" ");
        for(int i = 0; i < strs.length; i++) {
            parse(sb, strs[i], ++suffix);
            if (i != strs.length-1)
                sb.append(' ');

        }
        return sb.toString();
    }

    public void parse(StringBuilder sb, String s, int suffix) {
        char c = s.charAt(0);
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E'
                || c == 'I' || c == 'O' || c == 'U') {
            sb.append(s).append("ma");
        } else {
            sb.append(s.substring(1)).append(s.charAt(0)).append("ma");
        }
        for (int i = 0; i < suffix; i++)
            sb.append('a');
    }
}

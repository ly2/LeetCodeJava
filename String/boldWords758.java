import java.util.Arrays;

public class boldWords758 {

    // original  4ms
    public String boldWords(String[] words, String S) {
        int[] bolds = new int[S.length()+1];
        for (String w : words) {
            int idx = S.indexOf(w);
            while (idx != -1) {
                Arrays.fill(bolds, idx, idx+w.length(), 1);
//                for (int i = idx; i < w.length()+idx; i++) {
//                    bolds[i] = 1;
//                }
                idx = S.indexOf(w, idx+1);
            }
        }
        StringBuilder sb = new StringBuilder();

        boolean addbold = false;
        for (int i = 0; i < S.length(); i++) {

            if (bolds[i] == 1 && !addbold) {
                sb.append("<b>");
                addbold = true;
            } else if (bolds[i] == 0   && addbold) {
                sb.append("</b>");
                addbold = false;
            }
            sb.append(S.charAt(i));
            if ( i == S.length()-1 && addbold)
                sb.append("</b>");
        }

        return sb.toString();
    }


    // 3ms, use the boolean array
    public String boldWords2(String[] words, String S) {
        boolean[] bolds = new boolean[S.length()+1];
        for (String w : words) {
            int idx = S.indexOf(w);
            while (idx != -1) {
                Arrays.fill(bolds, idx, idx+w.length(), true);
                idx = S.indexOf(w, idx+1);
            }
        }
        StringBuilder sb = new StringBuilder().append(bolds[0]?"<b>":"");

        for (int i = 0; i < S.length(); i++) {
            sb.append(S.charAt(i));
            if(!bolds[i] && bolds[i+1] )
                sb.append("<b>");
            else if(bolds[i] && !bolds[i+1])
                sb.append("</b>");
        }

        return sb.toString();
    }
}

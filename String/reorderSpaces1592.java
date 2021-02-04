import java.util.ArrayList;
import java.util.List;

public class reorderSpaces1592 {
    public String reorderSpaces(String text) {

        List<String> words = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int space = 0;
        for (char c : text.toCharArray()) {
            if (c == ' ') {
                space++;
                if (sb.length() > 0) {
                    words.add(sb.toString());
                    sb = new StringBuilder();
                }
            } else {
                sb.append(c);
            }
        }
        if (sb.length() > 0) words.add(sb.toString());
        int bet = words.size() == 1? 0: space/(words.size()-1);
        int tail = words.size() == 1? space: space%(words.size()-1);

        sb = new StringBuilder();
        for (int i = 0; i < words.size();i++) {
            sb.append(words.get(i));
            if (i == words.size()-1) {
                for (int j = 0; j < tail;j++) {
                    sb.append(' ');
                }
            } else {
                for (int j = 0; j < bet;j++) {
                    sb.append(' ');
                }
            }
        }
        return sb.toString();


    }

    public String reorderSpaces2(String text) {
        String[] words = text.trim().split("\\s+");

        int len = 0;
        for (String w : words) {
            len += w.length();
        }
        len = text.length() - len;
        if(words.length == 1) {
            if(len == 0)
                return text;
            else {
                StringBuilder sb = new StringBuilder();
                sb.append(words[0]);
                while(len--> 0) {
                    sb.append(' ');
                }
                return sb.toString();
            }
        }

        StringBuilder sb = new StringBuilder();
        int j = len/(words.length-1);
        sb.append(words[0]);
        for (int i = 1; i < words.length; i++) {
            for (int x = 0; x < j;x++) {
                sb.append(' ');
            }
            sb.append(words[i]);
        }
        int x = len%(words.length-1);
        if (x != 0) {
            while(x--> 0) {
                sb.append(' ');
            }
        }

        return sb.toString();
    }
}

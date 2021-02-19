import java.util.ArrayList;
import java.util.List;

public class generatePossibleNextMoves293 {

    public List<String> generatePossibleNextMoves(String s) {
        ArrayList<String> list = new ArrayList<>();
        char[] chs = s.toCharArray();
        for (int i = 1; i < chs.length; i++) {
            if (chs[i] == '+' && chs[i-1] == '+') {
                chs[i] = chs[i-1] = '-';
                list.add(new String(chs));
                // list.add(String.valueOf(chs));
                chs[i] = chs[i-1] = '+';
            }
        }
        return list;
    }
}

import java.util.HashMap;
import java.util.Map;

public class toHexspeak1271 {

    public String toHexspeak(String num) {
        StringBuilder result = new StringBuilder();
        long n = Long.parseLong(num);
        while (n > 0) {
            int currDigit = (int) (n % 16);
            if (currDigit == 0) {
                result.append('O');
            } else if (currDigit == 1) {
                result.append('I');
            } else if (currDigit >= 10 ){
                result.append((char) (currDigit - 10 + 'A'));
            } else {
                return "ERROR";
            }
            n /= 16;
        }
        return result.reverse().toString();
    }

    Map<Integer, Character> map;

    public String toHexspeak1(String num) {
        map = new HashMap<>();
        map.put(1,'I');
        map.put(0, 'O');
        map.put(10, 'A');
        map.put(11, 'B');
        map.put(12, 'C');
        map.put(13, 'D');
        map.put(14, 'E');
        map.put(15, 'F');

        long value = Long.valueOf(num);
        StringBuilder sb = new StringBuilder();
        while (value != 0) {
            int d = (int) (value % 16);
            if ( d<10 && d > 1)
                return "ERROR";
            sb.append(map.get(d));
            value /= 16;
        }

        return sb.reverse().toString();
    }

    public String toHexspeak2(String num) {

        String s = Long.toHexString(Long.valueOf(num));
        char[] chs = s.toCharArray();
        for (int i  = 0; i < chs.length; i++) {
            if (Character.isDigit(chs[i])) {
                if (chs[i] == '1') {
                    chs[i] = 'I';
                } else if (chs[i] == '0') {
                    chs[i] = 'O';
                } else
                    return "ERROR";
            } else {
                chs[i] = Character.toUpperCase(chs[i]);
            }
        }
        return new String(chs);
    }
}

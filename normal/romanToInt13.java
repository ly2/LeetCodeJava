import java.util.HashMap;

public class romanToInt13 {
    static HashMap<String, Integer> values = new HashMap<>();

    static {
        values.put("M", 1000);
        values.put("D", 500);
        values.put("C", 100);
        values.put("L", 50);
        values.put("X", 10);
        values.put("V", 5);
        values.put("I", 1);
    }

    public int romanToInt(String s) {
        int total = 0;
        int current = 0;
        for (int i = s.length()-1; i >= 0; i --) {
            int tmp = values.get(s.substring(i,i+1));
            if (tmp >= current) {
                total += tmp;
                current = tmp;
            } else {
                total -= tmp;
            }
        }
        return total;
    }
}

import java.util.HashMap;

public class firstUniqChar387 {


    public int firstUniqChar(String s) {

        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.getOrDefault(c, -1) == -1)
                map.put(c, i);
            else
                map.put(c, Integer.MAX_VALUE);
        }
        int min = s.length();
        for (int i : map.values() )
            min = Math.min(min, i);

        return min == s.length()? -1: min;
    }



    // genius !!!
    //
    public int firstUniqChar2(String s) {
        if(s == null || s.length() == 0) return -1;
        int min = Integer.MAX_VALUE;
        for(char ch = 'a'; ch <= 'z'; ch++){
            int idx = s.indexOf(ch);
            if(idx != -1 && idx == s.lastIndexOf(ch)) min = Math.min(min, idx);
        }

        return min == Integer.MAX_VALUE ? -1 : min;

    }
}

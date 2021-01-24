import java.util.HashMap;

public class wordPattern290 {

    public boolean wordPattern(String pattern, String s) {
            String[] words = s.split(" ");
            char[] chs = pattern.toCharArray();


            if(words.length != chs.length)
                return false;

            HashMap<Character, String> map = new HashMap<>();

            for(int i = 0; i < words.length; i++) {
                if(map.getOrDefault(chs[i], null) == null) {
                    if(map.containsValue(words[i]))
                        return false;
                    map.put(chs[i], words[i]);

                } else{
                    if(!map.get(chs[i]).equals(words[i]))
                        return false;
                }
            }

            return true;
        }

}

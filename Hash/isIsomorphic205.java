import java.util.HashMap;

public class isIsomorphic205 {




    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length())
            return false;
        HashMap<Character, Character> map = new HashMap<>();
        char[] chs1 = s.toCharArray();
        char[] chs2 = t.toCharArray();
        for (int i = 0; i < chs1.length;i++) {
            if (map.getOrDefault(chs1[i], null) == null) {
                if (map.containsValue(chs2[i]))
                    return false;
                map.put(chs1[i], chs2[i]);

            }
            else
                if (map.get(chs1[i])!= chs2[i])
                    return false;
        }

        return true;
    }



    // use the array to store the char pairs!

    public boolean isIsomorphic2(String s, String t) {
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();
        char[] sMap = new char[256];
        char[] tMap = new char[256];
        for(int i = 0; i < sChar.length; i++){
            if(sMap[sChar[i]] == 0 && tMap[tChar[i]] == 0){
                sMap[sChar[i]] = tChar[i];
                tMap[tChar[i]] = tChar[i];
            }else if(sMap[sChar[i]] != tMap[tChar[i]]){
                return false;
            }
        }
        return true;
    }
}

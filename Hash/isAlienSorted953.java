import java.util.HashMap;

public class isAlienSorted953 {

    HashMap<Character, Integer> map = new HashMap<>();
    public boolean isAlienSorted(String[] words, String order) {
        if (words.length <= 1)
            return true;
        for (int i = 0; i < order.length();i++) {
            map.put(order.charAt(i), i);
        }
        for (int i = 1; i < words.length; i++) {
            if ( !compare(words[i-1], words[i]))
                return false;
        }

        return true;
    }

    public boolean compare(String s1, String s2) {
        int l = Math.min(s1.length(), s2.length());
        for (int i = 0; i < l; i++) {
            if (map.getOrDefault(s1.charAt(i),0) < map.getOrDefault(s2.charAt(i),0)) {
                return true;
            }
            if (map.getOrDefault(s1.charAt(i),0) > map.getOrDefault(s2.charAt(i),0)) {
                return false;
            }
        }
        return s1.length() <= s2.length();
    }




    // 0ms
    public boolean isAlienSorted2(String[] words, String order) {

        int[] orderIndexMap = toOrderIndexMap(order);

        String prevWord = "";
        for (String word: words) {
            if (!compare(prevWord, word, orderIndexMap)) {
                return false;
            }
            prevWord = word;
        }

        return true;
    }



    public int[] toOrderIndexMap(String order) {

        int orderIndexMap[] = new int[26];

        for (int ii = 0; ii < order.length(); ii++) {
            orderIndexMap[order.charAt(ii) - 'a'] = ii;
        }
        return orderIndexMap;
    }


    public boolean compare(String wordBefore, String wordAfter, int[] orderIndexMap) {
        int minLength = Math.min(wordBefore.length(), wordAfter.length());
        for (int ii = 0; ii < minLength; ii++) {
            int orderIndexBefore = orderIndexMap[wordBefore.charAt(ii) - 'a'];
            int orderIndexAfter = orderIndexMap[wordAfter.charAt(ii) - 'a'];
            if (orderIndexAfter > orderIndexBefore) {
                return true;
            } else if (orderIndexAfter < orderIndexBefore) {
                return false;
            }
        }
        if (wordAfter.length() < wordBefore.length())
            return false;
        return true;
    }

}

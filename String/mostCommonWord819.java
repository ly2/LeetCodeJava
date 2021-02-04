import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class mostCommonWord819 {


    public String mostCommonWord(String paragraph, String[] banned) {
        HashSet<String> set = new HashSet<>();
        for (String s : banned) {
            set.add(s);
        }
        StringBuilder sb = new StringBuilder();
        HashMap<String, Integer> map = new HashMap<>();
        for (char ch : paragraph.toCharArray()) {
            if (Character.isLetter(ch)) {
                sb.append(Character.toLowerCase(ch));
            } else if (sb.length() > 0) {
                String word = sb.toString();
                if (!set.contains(word)) {
                    map.put(word, map.getOrDefault(word, 0)+1);
                }
                sb = new StringBuilder();
            }
        }
        if (sb.length() > 0 ) {
            String word = sb.toString();
            if (!set.contains(word)) {
                map.put(word, map.getOrDefault(word, 0)+1);
            }
        }
        int max = -1;
        String ans = "";
        for (String w : map.keySet()) {
            if (map.get(w) > max) {
                max = map.get(w);
                ans = w;
            }
        }



        return ans;
    }



    // official ans
    public String mostCommonWord2(String paragraph, String[] banned) {

        Set<String> bannedWords = new HashSet();
        for (String word : banned)
            bannedWords.add(word);

        String ans = "";
        int maxCount = 0;
        Map<String, Integer> wordCount = new HashMap();
        StringBuilder wordBuffer = new StringBuilder();
        char[] chars = paragraph.toCharArray();

        for (int p = 0; p < chars.length; ++p) {
            char currChar = chars[p];

            // 1). consume the characters in a word
            if (Character.isLetter(currChar)) {
                wordBuffer.append(Character.toLowerCase(currChar));



                // this part is great!!!
                if (p != chars.length - 1)
                    // skip the rest of the processing
                    continue;


                //////
            }

            // 2). at the end of one word or at the end of paragraph
            if (wordBuffer.length() > 0) {
                String word = wordBuffer.toString();
                // identify the maximum count while updating the wordCount table.
                if (!bannedWords.contains(word)) {
                    int newCount = wordCount.getOrDefault(word, 0) + 1;
                    wordCount.put(word, newCount);
                    if (newCount > maxCount) {
                        ans = word;
                        maxCount = newCount;
                    }
                }
                // reset the buffer for the next word
                wordBuffer = new StringBuilder();
            }
        }
        return ans;
    }
}

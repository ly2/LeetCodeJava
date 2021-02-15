import java.util.HashSet;

public class uniqueMorseRepresentations804 {


    public int uniqueMorseRepresentations(String[] words) {
        if (words.length == 1)
            return 1;
        String[] morse = new String[] {
                ".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."
        };
        HashSet<String> set = new HashSet<>();
        for (String word : words) {
            StringBuilder sb = new StringBuilder();
            for (char c : word.toCharArray()) {
                sb.append(morse[c-'a']);
            }
            set.add(sb.toString());
        }

        return set.size();
    }
}

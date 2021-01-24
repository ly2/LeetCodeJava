import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class commonChars1002 {
    public List<String> commonChars(String[] A) {
        int[] count = new int[26];
        Arrays.fill(count, Integer.MAX_VALUE);

        for(String str : A) {
            int[] cnt = new int[26];
            for(char ch : str.toCharArray()) {
                cnt[ch-'a']++;
            }
            for(char ch = 'a'; ch <= 'z'; ch++) {
                count[ch-'a'] = Math.min(count[ch-'a'], cnt[ch-'a']);
            }
        }

        ArrayList<String> ans = new ArrayList<>();
        for(char ch = 'a'; ch <= 'z'; ch++) {
            while(count[ch-'a']-- > 0) ans.add(""+ch);
        }

        return ans;
    }
}

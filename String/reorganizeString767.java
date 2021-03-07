import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class reorganizeString767 {
    public String reorganizeString(String S) {
        if (S.length() == 1)
            return S;
        int[][] arr = new int[26][2];
        for (int i = 0; i < arr.length;i++) {
            arr[i][0] = i+'a';
        }
        for (char c : S.toCharArray()) {
            arr[c-'a'][1] ++;
        }
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1]-o1[1];
            }
        });

        if (arr[0][1] > (S.length() + 1) / 2)
            return "";
        char[] chars = new char[S.length()];
        int i = 0;
        for (int[] ch_arr : arr) {
            while (ch_arr[1] > 0) {
                if (i < S.length()) {
                    chars[i] = (char) ch_arr[0];
                    i+= 2;
                    ch_arr[1]--;
                } else {
                    i = 1;
                }
            }
        }
        return new String(chars);

    }


    // submission method! just locate the most frequent char firstly, others don'' matter
    public String reorganizeString2(String S) {

        int[] freq = new int[26];
        for(char ch : S.toCharArray()) {
            freq[ch - 'a']++;
        }

        int max = 0;
        int letter = 0;
        for(int i = 0; i < 26; i++) {
            if(freq[i] > max) {
                max = freq[i];
                letter = i;
            }
        }

        if(max > (S.length() + 1) / 2) {
            return "";
        }

        char[] result = new char[S.length()];
        int index = 0;
        // Fill the max letter at index = 0, 2, 4, ...
        while(freq[letter] > 0) {
            result[index] = (char) (letter + 'a');
            freq[letter]--;
            index = index + 2;
        }

        // Fill the remaining letters
        for(int i = 0; i < 26; i++) {
            while(freq[i] > 0) {
                if(index >= result.length) {
                    index = 1;
                }
                result[index] = (char) (i + 'a');
                freq[i]--;
                index = index + 2;
            }
        }
        return new String(result);
    }
}

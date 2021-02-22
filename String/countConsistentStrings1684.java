public class countConsistentStrings1684 {

    // after opt   5ms
    public int countConsistentStrings1(String allowed, String[] words) {
        int[] allowed_arr = new int[26];
        for (char c : allowed.toCharArray()) {
            allowed_arr[c-'a'] = 1;
        }
        int count = 0;
        for (String word : words) {
            boolean iscpunted = true;
            for (char c : word.toCharArray()) {
                if (allowed_arr[ c-'a'] == 0) {
                    iscpunted = false;
                    break;
                }
            }
            if (iscpunted)
                count++;
        }

        return count;
    }



    // submission method   4ms
    public int countConsistentStrings(String allowed, String[] words) {
        int[] allowed_arr = new int[26];
        for (char c : allowed.toCharArray()) {
            allowed_arr[c-'a'] = 1;
        }
        int count = 0;
        for (String word : words) {
            if (checkWord(word, allowed_arr))
                count++;
        }

        return count;
    }

    private boolean checkWord(String word, int[] map) {
        for (int i = 0; i < word.length(); i++) {
            if (map[word.charAt(i) - 'a'] == 0) {
                return false;
            }
        }
        return true;
    }


    // original  6ms
    public int countConsistentStrings2(String allowed, String[] words) {
        boolean[] allowed_arr = new boolean[26];
        for (char c : allowed.toCharArray()) {
            allowed_arr[c-'a'] = true;
        }
        int count = 0;
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                if (!allowed_arr[ word.charAt(i)-'a']) {
                    break;
                }
                if (i == word.length()-1)
                    count++;
            }
        }

        return count;
    }
}

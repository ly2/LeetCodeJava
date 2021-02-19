public class detectCapitalUse520 {


    // original
    public boolean detectCapitalUse1(String word) {
        char c = word.charAt(0);
        if (Character.isUpperCase(c)) {
            if (word.toUpperCase().equals(word))
                return true;
            else
                return word.substring(1).toLowerCase().equals(word.substring(1));
        } else {
            return word.toLowerCase().equals(word);
        }
    }



    // optimisation 0ms
    public boolean detectCapitalUse(String word) {
        if (word.length() == 1)
            return true;

        if (word.charAt(0) < 'a' &&  word.charAt(1) < 'a') {
            for (int i = 1; i < word.length(); i++) {
                if (word.charAt(i) >= 'a')
                    return false;
            }
        } else {
            for (int i = 1; i < word.length(); i++) {
                if (word.charAt(i) < 'a')
                    return false;
            }
        }
        return true;
    }
}

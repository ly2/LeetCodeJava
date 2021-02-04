public class buddyStrings859 {


    public boolean buddyStrings(String A, String B) {
        if (A.length() != B.length())
            return false;

        if (A.equals(B)) {
            int[] count = new int[26];
            for (char c : A.toCharArray()) {
                if (count[c - 'a'] > 0) {
                    return true;
                }
                count[c - 'a']++;
            }
            return false;
        } else {
            boolean swaped = false;
            boolean dif = false;
            int prev = -1;
            for (int i = 0; i < A.length(); i++) {
                if (A.charAt(i) != B.charAt(i)) {
                    if (swaped)
                        return false;
                    else {
                        if (!dif) {
                            prev = i;
                            dif = true;
                        } else {
                            if (A.charAt(prev) == B.charAt(i) && B.charAt(prev) == A.charAt(i))
                                swaped = true;
                            else
                                return false;
                        }

                    }
                }

            }
            return swaped;
        }

    }
}

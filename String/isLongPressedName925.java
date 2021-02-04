public class isLongPressedName925 {


    public boolean isLongPressedName(String name, String typed) {
        if (name.length() > typed.length())
            return false;
        if (name.equals(typed))
            return true;
        char[] name_arr = name.toCharArray();
        char[] typed_arr = typed.toCharArray();
        int i = 0, j = 0;


        int count = 0;

        while (i < name_arr.length) {
            count++;
            if (i+1 < name_arr.length && name_arr[i] == name_arr[i+1]) {
                i++;
                continue;
            } else {
                while ( j < typed_arr.length) {
                    if (typed_arr[j] == name_arr[i]) {
                        count--;
                    } else {
                        if (count > 0)
                            return false;
                        break;
                    }
                    j++;
                }
                if (count > 0 )
                    return false;
                i++;
                count = 0;
            }
        }
        return !(j < typed_arr.length);
    }

    // faster!
    public boolean isLongPressedName1(String name, String typed) {

        // two pointers to the "name" and "typed" string respectively
        int np = 0, tp = 0;
        // convert the string to array of chars, for ease of processing later.
        char[] name_chars = name.toCharArray();
        char[] typed_chars = typed.toCharArray();

        // advance two pointers, until we exhaust one of the strings
        while (np < name_chars.length && tp < typed_chars.length) {
            if (name_chars[np] == typed_chars[tp]) {
                np += 1;
                tp += 1;
            } else if (tp >= 1 && typed_chars[tp] == typed_chars[tp - 1]) {
                tp += 1;
            } else {
                return false;
            }
        }

        // if there is still some characters left *unmatched* in the origin string,
        // then we don't have a match.
        // e.g. name = "abc" typed = "aabb"
        if (np != name_chars.length) {
            return false;
        } else {
            // In the case that there are some redundant characters left in typed
            // we could still have a match.
            // e.g. name = "abc" typed = "abccccc"
            while (tp < typed_chars.length) {
                if (typed_chars[tp] != typed_chars[tp - 1])
                    return false;
                tp += 1;
            }
        }

        // both strings have been consumed.
        return true;
    }


    // genius!!!
    public boolean isLongPressedName2(String name, String typed) {
        int i = 0, m = name.length(), n = typed.length();
        for (int j = 0; j < n; ++j) {
            if (i < m && name.charAt(i) == typed.charAt(j))
                ++i;
            else if (j == 0 || typed.charAt(j) != typed.charAt(j - 1))
                return false;
        }
        return i == m;
    }
}

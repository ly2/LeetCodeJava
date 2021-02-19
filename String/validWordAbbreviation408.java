public class validWordAbbreviation408 {

//    public boolean validWordAbbreviation(String word, String abbr) {
//        char[] w_arr = word.toCharArray();
//        int j = 0, i = 0;
//
//        while (i < abbr.length()) {
//            if (Character.isDigit(abbr.charAt(i))) {
//                if (abbr.charAt(i) - '0' == 0)
//                    return false;
//                int n = 0;
//
//                while (i < abbr.length() && Character.isDigit(abbr.charAt(i))) {
//                    n = n * 10 + (abbr.charAt(i) - '0');
//                    i++;
//                }
//                j += n;
//            }
//            if (j >= word.length() || i >= abbr.length())
//                break;
//            if ( abbr.charAt(i) != w_arr[j] )
//                return false;
//            i++;
//            j++;
//        }
//        return j == word.length() && i == abbr.length();
//    }

    // original solution
    public boolean validWordAbbreviation1(String word, String abbr) {
        char[] w_arr = word.toCharArray();
        char[] a_arr = abbr.toCharArray();
        int j = 0, i = 0;

        while (i < a_arr.length) {
            if(a_arr[i] >= '0' && a_arr[i] <= '9') {
                if (a_arr[i] == '0')
                    return false;
                int n = 0;

                while (i < a_arr.length && Character.isDigit(a_arr[i])) {
                    n = n * 10 + (a_arr[i] - '0');
                    i++;
                }
                j += n;
            }
            if (j >= word.length() || i >= abbr.length())
                break;
            if ( a_arr[i] != w_arr[j] )
                return false;
            i++;
            j++;
        }
        return j == word.length() && i == abbr.length();
    }



    // much faster because of the optimisation in the condition if ch is digit!
    public boolean validWordAbbreviation(String word, String abbr) {
        if (word.length() < abbr.length())
            return false;

        int j = 0, i = 0, n = 0;
        while (i < abbr.length()) {
            char ch = abbr.charAt(i);
            if((ch > '0' && ch <= '9') || (n > 0 && ch >= '0' && ch <= '9')){
                n = n * 10 + (ch - '0');
            } else {
                j += n;
                if ( j < word.length() && abbr.charAt(i) != word.charAt(j) )
                    return false;
                n = 0;
                j++;

            }
            i++;


        }
        return j + n == word.length();
    }
}

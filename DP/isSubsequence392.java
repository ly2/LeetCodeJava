public class isSubsequence392 {

    public boolean isSubsequence(String s, String t) {
        if(s.isEmpty())
            return true;
        if(s.length() > t.length()){
            return false;
        }
        char[] s_arr = s.toCharArray();
        int i = 0;
        for(char ch : t.toCharArray()) {
            if(ch == s_arr[i]) {
                i++;
                if (i == s_arr.length)
                    return true;
            }

        }
        return false;
    }


}

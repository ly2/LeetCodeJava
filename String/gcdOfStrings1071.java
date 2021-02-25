public class gcdOfStrings1071 {
    public String gcdOfStrings(String str1, String str2) {
        if (str1.length() > str2.length())
            return gcdOfStrings(str2, str1);

        if (isDivisor(str1, str2))
            return str1;

        String ans = str1.substring(0,1);



        if (isDivisor(ans, str1) && isDivisor(ans, str2)) {
            if (str1.length() % 2 != 0 || str2.length()%2 != 0) {
                return ans;
            }
        } else {
            ans = "";
        }


        for (int i = 2; i <= str1.length()/2+1; i++) {
            String tmp = str1.substring(0, i);
            if (isDivisor(tmp, str1) && isDivisor(tmp, str2))
                ans = tmp;
        }
        return ans;
    }

    private boolean isDivisor(String a, String b) {
        if (b.length() % a.length() != 0)
            return false;
        int i = 0;
        for (char bc : b.toCharArray()) {
            if (bc != a.charAt(i))
                return false;
            i++;
            if (i == a.length())
                i = 0;
        }
        return true;
    }



    // submission method! much efficient!
    public String gcdOfStrings2(String str1, String str2) {
        // Make sure str1 is the longer string
        // if str1 doesnt start with str2
        //      return ""
        // if str2 is empty
        //      return str1
        // else recursively taking off str1;


        if (str1.length() < str2.length()) {
            return gcdOfStrings(str2, str1);
        } else if (!str1.startsWith(str2)) {
            return "";
        } else if (str2.isEmpty()) {
            return str1;
        } else {
            return gcdOfStrings(str1.substring(str2.length()), str2);
        }
    }
}

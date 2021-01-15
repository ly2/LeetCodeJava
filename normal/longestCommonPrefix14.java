

public class longestCommonPrefix14 {



    // 100.00% 0 ms	37.1 MB
    // binary search
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";
        int minLen = Integer.MAX_VALUE;
        for (String str : strs)
            minLen = Math.min(minLen, str.length());
        int low = 1;
        int high = minLen;
        while (low <= high) {
            int middle = (low + high) / 2;
            if (isCommonPrefix(strs, middle))
                low = middle + 1;
            else
                high = middle - 1;
        }
        return strs[0].substring(0, (low + high) / 2);
    }

    private boolean isCommonPrefix(String[] strs, int len){
        String str1 = strs[0].substring(0,len);
        for (int i = 1; i < strs.length; i++)
            if (!strs[i].startsWith(str1))
                return false;
        return true;
    }
    // general method,1 ms	37.2 MB
    public String longestCommonPrefix2(String[] strs) {
        String ans = "";
        if (strs.length == 0)
            return ans;

        int end = strs[0].length()-1;
        int i = strs[0].length()-1;
        while (i >=0) {

            for (String s : strs) {
                if (s.length() <= i) {
                    i = s.length();
                    end = s.length() - 1;
                    break;
                } else {
                    if (s.charAt(i) != strs[0].charAt(i)) {
                        end = i - 1;
                        break;
                    }
                }

            }
            i--;

        }
        return end == -1? "": strs[0].substring(0, end+1);
    }
}

public class longestPalindrome5 {

    public String longestPalindrome(String s) {
        if (s == null || s.isEmpty())
            return null;
        if(s.length() == 1)
            return s;
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = helper(s, i, i);
            int len2 = helper(s, i, i+1);

            int len = Math.max(len1, len2);
            if (len > end-start) {
                start = i - (len-1)/2;
                end = i + len/2;
            }
        }



        return s.substring(start, end+1);
    }

    private int helper(String s , int start, int end) {
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
        }

        return end - start-1;
    }



    int start=0, end=0;
    public String longestPalindrome2(String s) {
        if(s.length()<2)
            return s;
        char[] c= s.toCharArray();
        LongestPalindrome(c,0);
        return s.substring(start, end+1);
    }

    public void LongestPalindrome(char c[], int p)
    {
        int a= p;
        int b=p;
        int n= c.length;
        if(p>=n-1)
            return;
        while(b<n-1 && c[b]==c[b+1])
        {
            b++;
        }
        p=b;
        while(a>0 && b<n-1 && c[a-1]==c[b+1])
        {
            a--;
            b++;
        }
        if(b-a > end- start)
        {
            start=a;
            end=b;
        }
        LongestPalindrome(c, p+1);
    }
}

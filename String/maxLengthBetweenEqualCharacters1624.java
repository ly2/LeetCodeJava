import java.util.Arrays;

public class maxLengthBetweenEqualCharacters1624 {
    public int maxLengthBetweenEqualCharacters(String s) {
        int len = 0;
        for (int i = 0; i < 26; i++) {
            char c = (char) ('a' + i);
            len = Math.max( len, s.lastIndexOf(c) - s.indexOf(c));
        }
        return len == 0? -1: len-1;
    }

    // improved, less runtime memory
    public int maxLengthBetweenEqualCharacters1(String s) {
        int len = -1;
        for (char c = 'a'; c <= 'z'; c++) {
            len = Math.max( len, s.lastIndexOf(c) - s.indexOf(c)-1);
        }
        return len;
    }




    // submission method, same performance!
    public int maxLengthBetweenEqualCharacters2(String s) {
        int[] a=new int[26];
        int maxLen=-1,len=0;
        Arrays.fill(a,-1);

        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(a[ch-'a']==-1)
                a[ch-'a']=i;
            else{
                len=i-a[ch-'a']-1;
                maxLen=Math.max(len,maxLen);
            }

        }
        return maxLen;
    }
}

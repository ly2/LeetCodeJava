public class reverseStr541 {

    public String reverseStr(String s, int k) {
        StringBuilder sb = new StringBuilder();
        char[] chs = s.toCharArray();
        for (int i = 0; i < s.length(); i += 2*k) {
            reversePart(sb, chs, i, k);
        }
        return sb.toString();
    }

    public void reversePart(StringBuilder sb, char[] chs, int index, int k) {
        int start = Math.min(chs.length-1, index+k-1);
        for (int i = start; i >= index;i--) {
            sb.append(chs[i]);
        }
        int end = Math.min(chs.length-1, start+k);
        for (int i = start+1; i <= end; i++) {
            sb.append(chs[i]);
        }
    }


    // two pointer reverse
    public String reverseStr2(String s, int k) {
        if(s.length() == 0 || k <= 1) return s;
        char[] chars = s.toCharArray();
        int i=0;
        while(i+k<chars.length) {
            reverse(chars,i,i+k-1);
            i+=2*k;
        }
        if(i<chars.length) {
            reverse(chars,i,chars.length-1);
        }
        return new String(chars);
    }

    void reverse(char[] chars,int start,int end) {
        int i=start,j=end;
        while(i<j) {
            char tmp = chars[i];
            chars[i] = chars[j];
            chars[j] = tmp;
            i++;
            j--;
        }
    }
}

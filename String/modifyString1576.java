public class modifyString1576 {
    public String modifyString(String s) {

        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '?') {
                for (int j = 0; j < 3; j++) {
                    if (i> 0 && arr[i-1] -'a' == j) continue;
                    if (i+1 < arr.length && arr[i+1]-'a' == j) continue;
                    arr[i] = (char) (j+'a');
                    break;
                }
            }
        }
        return new String(arr);
    }


    public String modifyString2(String s) {
        int prev = -1;
        StringBuilder sb = new StringBuilder();
        char[] chs = s.toCharArray();
        for (int i = 0; i < chs.length; i++) {
            if (!Character.isLetter(chs[i])) {
                if (i+1 >= chs.length || !Character.isLetter(chs[i+1]) ) {
                    int c = replace(prev, -1);
                    sb.append((char)(c+'a'));
                    prev = c;
                } else {
                    int c = replace(prev, chs[i+1]-'a');
                    sb.append((char)(c+'a'));
                    prev = c;
                }
            } else {
                sb.append(chs[i]);
                prev = chs[i]-'a';
            }
        }
        return sb.toString();
    }

    public int replace(int a, int b) {
        for (int i = 0; i < 26; i++) {
            if (i != a && i != b)
                return i;
        }
        return 0;

    }
}

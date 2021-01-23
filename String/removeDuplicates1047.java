import java.util.Arrays;

public class removeDuplicates1047 {

    // use the chs as a stack. 5 ms	39.2 MB
    public String removeDuplicates(String S) {

        char[] chs = new char[S.length()];
        int idx = -1;
        for (int i = 0; i < S.length(); i++) {
            if (idx == -1 || chs[idx] != S.charAt(i)) {
                idx++;
                chs[idx] = S.charAt(i);
            } else
                idx--;
        }
        Arrays.copyOf(chs, idx+1);
        return String.valueOf(chs);
    }


    //
    public String removeDuplicates2(String S) {

        char[] arr = S.toCharArray();

        int idx = 0;

        for (int i = 0 ; i < S.length();idx++, i++) {
            arr[idx] = arr[i];
            if (idx > 0 && arr[idx-1] == arr[idx]) idx-= 2;
        }
        return new String(arr, 0, idx);
    }
}

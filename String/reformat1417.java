public class reformat1417 {

    public String reformat(String s) {

        int d = 0, l = 0;
        for (char c : s.toCharArray()) {
            if ( c <= '9')
                d++;
            else
                l++;
        }
        if (Math.abs(d-l) > 1)
            return "";

        char[] arr = new char[s.length()];
        d =  d > l ? 0:1;
        l = 1-d;
        for (char c : s.toCharArray()) {
            if ( c <= '9') {
                    arr[d] = c;
                    d += 2;
            } else {
                    arr[l] = c;
                    l += 2;
            }
        }
        return new String(arr);
    }
}

public class compress443 {

    public int compress(char[] chars) {
        if (chars.length < 2)
            return chars.length;
        int count = 0;
        int len = 0;
        for (int i =0; i < chars.length-1; i++) {
            count++;
            if (chars[i] != chars[i+1]) {
                if (count > 1) {
                    chars[len++] = chars[i];
                    String tmp = String.valueOf(count);
                    for (char c : tmp.toCharArray()) {
                        chars[len++] = c;
                    }
                } else {
                    chars[len++] = chars[i];
                }
                count = 0;
            }

        }
        if (count == 0)
            chars[len++] = chars[chars.length-1];
        else {
            chars[len++] = chars[chars.length-1];
            count++;
            String tmp = String.valueOf(count);
            for (char c : tmp.toCharArray()) {
                chars[len++] = c;
            }
        }
        return len;
    }

    // submission method 0ms
    public int compress2(char[] chars) {
        if (chars == null || chars.length == 0) return 0;
        int l = 0;
        int r = 1;
        int pos = 0;
        while (r < chars.length) {
            if (chars[l] == chars[r]) r++;
            else {
                chars[pos++] = chars[l];
                if (r - l > 1) {
                    if (r - l < 10) {
                        chars[pos++] = (char) (r - l + '0');
                    } else {
                        String tmp = String.valueOf(r - l);
                        for (char c : tmp.toCharArray()) {
                            chars[pos++] = c;
                        }
                    }
                }
                l = r;
            }
        }
        chars[pos++] = chars[l];
        if (r - l > 1) {
            if (r - l < 10) {
                chars[pos++] = (char) (r - l + '0');
            } else {
                String tmp = String.valueOf(r - l);
                for (char c : tmp.toCharArray()) {
                    chars[pos++] = c;
                }
            }
        }
        return pos;
    }
}

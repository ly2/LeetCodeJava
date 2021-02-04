public class reverseVowels345 {

    public String reverseVowels(String s) {

        char[] chs = s.toCharArray();
        int left = 0, right = chs.length-1;
        while (left<right) {
            if (!isvow(chs[left])) {
                left++;
            }
            if (!isvow(chs[right])) {
                right--;
            }
            if (isvow(chs[left]) && isvow(chs[right])) {
                char tmp = chs[left];
                chs[left] = chs[right];
                chs[right] = tmp;
                left++;
                right--;
            }

        }
        return new String(chs);

    }

    public boolean isvow(char c) {
        c = Character.toLowerCase(c);
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
            return true;
        return false;
    }
}

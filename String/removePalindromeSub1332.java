public class removePalindromeSub1332 {

    // input sample : abbaaa     output: 2


    //  0 ms	36.9 MB
    // simple idea cause its not substring, it is subsequence!!!
    public int removePalindromeSub(String s) {
        if (s.isEmpty())
            return 0;

        char[] arr = s.toCharArray();
        int i = 0, j = arr.length-1;
        while (i < j) {
            if (arr[i++] != arr[j--])
                return 2;
        }
        return 1;

    }

    // submission method
    //	0 ms	36.6 MB
    public int removePalindromeSub2(String s) {
        char[] sc = s.toCharArray();
        if (sc.length == 0)  return 0;
        for (int i = sc.length / 2; i >= 0; i--)
            if (sc[i] != sc[sc.length - i - 1])
                return 2;
        return 1;

    }
}

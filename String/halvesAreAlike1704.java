public class halvesAreAlike1704 {
    public boolean halvesAreAlike(String s) {
        char[] arr = s.toCharArray();
        int count1 = 0, count2 = 0;
        for (int i = 0, j = arr.length/2; j < arr.length; i++, j++) {
            if (isvowel(arr[i]))
                count1++;
            if (isvowel(arr[j]))
                count2++;
        }
        return count1 == count2;
    }

    public boolean isvowel(char c) {
        return  (c == 'a' || c =='e' || c == 'i' || c == 'o' || c == 'u' || c == 'A'|| c =='E' || c == 'I' || c == 'O' || c == 'U');
    }






    // submission method! 0 ms	37 MB
    public int result(String s, int l, int r, boolean[] arr, int count) {
        while(l < r){
            if(arr[s.charAt(l)-65]) count++;
            l++;
        }
        return count;
    }
    public boolean halvesAreAlike2(String s) {
        boolean arr[] = new boolean[58];
        arr['a'- 65] = arr['e'- 65] = arr['i'- 65] = arr['o'- 65] = arr['u'- 65] = arr['A'-65] = arr['E'-65] = arr['I'- 65] = arr['O'-65] = arr['U'-65] = true;
        return result(s, 0, s.length() / 2, arr, 0) == result(s, s.length() / 2, s.length(), arr, 0);
    }
}

public class reverseOnlyLetters917 {


    public String reverseOnlyLetters(String S) {

        char[] chs = S.toCharArray();
        int j = 0;
        char[] ans = new char[chs.length];
        for (int i = 0; i < chs.length;i++) {
            if (!Character.isLetter(chs[i]))
                ans[i] = chs[i];
        }
        for (int i = chs.length-1; i >= 0; i--) {
            if (Character.isLetter(chs[i])) {
                while (ans[j] != '\0')
                    j++;
                ans[j++] = chs[i];
            }

        }



        return new String(ans);
    }


    // operation on the original charArray is a better choice!!!
    public String reverseOnlyLetters2(String S) {
        int i=0;
        int j= S.length()-1;
        char [] ch = S.toCharArray();
        while(i<j)
        {
            if(!Character.isLetter(ch[i])){
                i++;
                continue;
            }
            if(!Character.isLetter(ch[j])){
                j--;
                continue;
            }
            char temp = ch[i];
            ch[i]=ch[j];
            ch[j]=temp;
            i++;
            j--;
        }


        return new String(ch);
    }
}

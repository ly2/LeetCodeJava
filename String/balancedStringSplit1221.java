public class balancedStringSplit1221 {

    public int balancedStringSplit(String s) {
        int count = 0;
        char[] chs = s.toCharArray();
        int bal = chs[0] == 'L'? -1 : 1;
        for (int i = 1; i < chs.length; i++) {
            if (chs[i] == 'L')
                bal--;
            else
                bal++;

            if (bal == 0)
                count++;
        }
        return count;
    }



    // much clean but need to use chararray
    public int balancedStringSplit2(String s) {
        int count=0, res=0;
        for(int i=0;i<s.length();i++){
            count += s.charAt(i) == 'L' ? 1 :-1;
            if(count == 0){
                res++;
            }
        }
        return res;
    }
}

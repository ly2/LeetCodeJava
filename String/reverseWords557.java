public class reverseWords557 {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        for (String word : s.split(" ")) {
            char[] chs = word.toCharArray();
            for (int i = chs.length-1; i >=0; i--) {
                sb.append(chs[i]);
            }
            sb.append(' ');
        }
        sb.deleteCharAt(s.length());

        return sb.toString();
    }



    //3 ms	39.2 MB
    public String reverseWords2(String s) {
        char[] array = s.toCharArray();

        if(array.length < 2)
            return s;

        reverse(0, array);

        return new String(array);

    }

    public void reverse(int i, char[] array){

        int start = i;

        while(i < array.length && array[i] != ' '){
            i++;
        }

        int end = i - 1;
        char temp;
        while(start < end){
            temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }

        if(i < array.length)
            reverse(i+1, array);

    }
}

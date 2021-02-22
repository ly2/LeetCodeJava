public class isPrefixOfWord1455 {

    public int isPrefixOfWord(String sentence, String searchWord) {
        char[] search = searchWord.toCharArray();
        int i = 0;
        for (String word : sentence.split(" ")) {
            i++;
            if (word.length() < search.length)
                continue;
            boolean flag = true;
            for (int j =0; j < search.length; j++) {
                if (search[j] != word.charAt(j)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return i;
            }

        }


        return -1;
    }


    // much clean
    public int isPrefixOfWord2(String sentence, String searchWord) {
        String[] words = sentence.split(" ");

        int i = 1;
        for (String  word : words){
            if (word.indexOf(searchWord) == 0)
                return i;
            i++;
        }
        return -1;
    }
}

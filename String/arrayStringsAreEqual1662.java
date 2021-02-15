public class arrayStringsAreEqual1662 {
    // 0ms
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {

        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for (String s : word1) {
            sb1.append(s);
        }
        for (String s : word2) {
            sb2.append(s);
        }
        return sb1.toString().equals(sb2.toString());
    }

    // original
    public boolean arrayStringsAreEqual1(String[] word1, String[] word2) {
        StringBuilder sb = new StringBuilder();

        for (String w : word1) {
            sb.append(w);
        }
        char[] chs = sb.toString().toCharArray();
        int i = 0;
        for (String w: word2) {
            for (char c : w.toCharArray()) {
                if ( i < chs.length && c == chs[i])
                    i++;
                else
                    return false;
            }


        }
        if (i != chs.length)
            return false;
        return true;
    }
}

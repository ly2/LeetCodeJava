public class canConstruct383 {


    public boolean canConstruct(String ransomNote, String magazine) {
        int[] chs = new int[26];
        for (char ch : ransomNote.toCharArray()) {
            chs[ch-'a']++;
        }
        for (char ch : magazine.toCharArray()) {
            chs[ch-'a']--;
        }
        for (int n : chs) {
            if (n > 0)
                return false;
        }


        return true;
    }
}

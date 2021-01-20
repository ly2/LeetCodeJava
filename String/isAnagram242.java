public class isAnagram242 {


    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;

        int[] counts = new int[26];

        for (char ch : s.toCharArray()) {
            counts[ch-'a']++;
        }
        for (char ch : t.toCharArray()) {
            if (counts[ch-'a']-- < 0) return false;
        }
        for (int n : counts)
            if (n != 0) return false;

        return true;

    }
}

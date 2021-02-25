public class findLUSlength521 {

    // misunderstanding for the uncommon subsequence...
/*
    public int findLUSlength(String a, String b) {
        if (a.equals(b))
            return -1;

        int countA = a.length(), countB = 0;

        int[] arr = new int[26];
        for (char c : a.toCharArray()) {
            arr[c-'a']++;
        }
        for (char c : b.toCharArray()) {
            if (arr[c-'a'] != 0) {
                countA -= arr[c-'a'];
            } else {
                countB++;
            }
        }



        return countA > countB? countA: countB;
    }*/

    public int findLUSlength(String a, String b) {
        if (a.equals(b))
            return -1;

        return Math.max(a.length(), b.length());
    }
}

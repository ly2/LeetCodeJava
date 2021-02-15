import java.util.*;

public class numSpecialEquivGroups893 {



    // deep understanding in Hash!!!
    public int numSpecialEquivGroups(String[] A) {
        Set<Integer> set = new HashSet<>();
        for (String s : A) {
            set.add(hashStr(s));
        }
        return set.size();
    }

    private int hashStr(String str) {
        int evenHash = 1242;
        int oddHash = 54764;
        char[] arr = str.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0) {
                evenHash *= arr[i];
            } else {
                oddHash *= arr[i];
            }
        }
        return evenHash + oddHash;
    }



    // genius!! 13 ms	39.3 MB
    public int numSpecialEquivGroups2(String[] A) {
        Set<String> seen = new HashSet();
        for (String S: A) {
            int[] count = new int[52];
            for (int i = 0; i < S.length(); ++i)
                count[S.charAt(i) - 'a' + 26 * (i % 2)]++;
            seen.add(Arrays.toString(count));
        }
        return seen.size();
    }


    //original edition 64 ms	38.4 MB
    public int numSpecialEquivGroups1(String[] A) {
        if (A.length == 1)
            return 1;

        HashMap<String, List<int[]>> map = new HashMap<>();
        for (String s : A) {
            boolean newkey = true;
            int[] ordarr = new int[26], evnarr = new int[26];
            for (int i = 0; i < s.length() ; i++) {
                if ((i+1)%2 == 1) {
                    ordarr[s.charAt(i) - 'a'] ++;
                } else {
                    evnarr[s.charAt(i) - 'a'] ++;
                }
            }

            for (String k : map.keySet()) {
                if (s.length() == k.length()) {
                    if (cmp(ordarr, evnarr, map.get(k))) {
                        newkey = false;
                        break;
                    }
                }
            }
            if (newkey) {
                ArrayList<int[]> list = new ArrayList<>();
                list.add(ordarr);
                list.add(evnarr);
                map.put(s, list);
            }
        }

        return map.size();
    }
    public boolean cmp(int[] ord, int[] even, List<int[]> list) {
        for (int i = 0; i < 26; i++) {
            if (ord[i] != list.get(0)[i] || even[i] != list.get(1)[i])
                return false;
        }
        return true;
    }
}

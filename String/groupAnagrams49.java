

import java.util.*;

public class groupAnagrams49 {

    // original  inefficient! 13 ms	43 MB
    public List<List<String>> groupAnagrams(String[] strs) {

        ArrayList<List<String>> ans = new ArrayList<>();
        if (strs.length == 0)
            return ans;

        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            String code = getCode(str);
            if (map.getOrDefault(code, null) == null) {
                map.put(code, new ArrayList<String>() {{add(str);}});
            } else {
                map.get(code).add(str);
            }
        }
        for (List list: map.values()) {
            ans.add(list);
        }

        return ans;
    }

    private String getCode(String s) {
        int[] arr = new int[26];
        for (char c: s.toCharArray()) {
            arr[c-'a'] ++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length;i++) {
            sb.append((char)(i+'a')).append(arr[i]);
            //sb.append('#').append(arr[i]);
        }
        return sb.toString();
    }



    // submission method! use the primes to store all characters. 3ms
    public List<List<String>> groupAnagrams2(String[] strs) {
        int length = strs.length;

        int[] primes = {2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,79,83,89,97,101};
        HashMap<Long, Integer> key_index_hm = new HashMap();

        List<List<String>> res = new ArrayList();
        int index = -1;

        for (int i = 0; i < length; i++) {
            int s_length = strs[i].length();
            long key = 1;

            if (s_length == 0) {
                key = -1;
            } else {
                for (int j = 0; j < s_length; j++) {
                    key *= primes[strs[i].charAt(j) - 'a'];
                }
            }

            Integer key_index = key_index_hm.get(key);

            if (key_index == null) {
                key_index_hm.put(key, ++index);
                key_index = index;

                res.add(new ArrayList());
            }

            res.get(key_index).add(strs[i]);
        }

        return res;
    }


    // use sort string, which is also a great method 6ms
    // useful for short string
    public List<List<String>> groupAnagrams3(String[] strs) {
        if (strs.length == 0) return new ArrayList();
        Map<String, List> ans = new HashMap<String, List>();
        for (String s : strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String key = String.valueOf(ca);
            if (!ans.containsKey(key)) ans.put(key, new ArrayList());
            ans.get(key).add(s);
        }
        return new ArrayList(ans.values());
    }

}

import java.util.HashMap;

public class maxNumberOfBalloons1189 {



    public int maxNumberOfBalloons(String text) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('b', 0);
        map.put('a', 0);
        map.put('l', 0);
        map.put('o', 0);
        map.put('n', 0);

        for(char ch : text.toCharArray()) {
            int c = map.getOrDefault(ch, -1);
            if(c != -1)
                map.put(ch, c+1);
        }
        map.put('l', map.get('l')/2);
        map.put('o', map.get('o')/2);
        int ans = Integer.MAX_VALUE;
        for(int count : map.values()) {
            ans = Math.min(ans, count);
        }
        return ans;
    }


    //faster!!
    public int maxNumberOfBalloons2(String text) {
        char[] cs = text.toCharArray();
        int[] ls = new int[26];
        for (char i : cs) {
            ls[i-'a']++;
        }
        //                          a      b
        int[] counts = new int[] { ls[0], ls[1], ls[11]/2, ls[13], ls[14]/2 };
        int min = Integer.MAX_VALUE;
        for (int i : counts) {
            min = Math.min(min,i);
        }
        return min;
    }
}

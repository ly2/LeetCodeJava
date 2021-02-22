public class calculateTime1165 {

    public int calculateTime(String keyboard, String word) {
        int[] keyb = new int[26];
        char[] arr = keyboard.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            keyb[arr[i]-'a'] = i;
        }
        int time = 0, prev = 0;
        for (char c : word.toCharArray()) {
            time += Math.abs(keyb[c-'a'] - prev);
            prev = keyb[c-'a'];
        }
        return time;
    }
}

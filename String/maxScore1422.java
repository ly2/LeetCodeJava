public class maxScore1422 {


    // original
    public int maxScore1(String s) {
        char[] arr = s.toCharArray();
        int[] scores = new int[s.length()-1];
        int  count = 0;
        for (int i = 0; i < arr.length-1; i++) {
            if (arr[i] == '0') {
                count++;
            }
            scores[i] = count;
        }

        int max = 0;
        count = 0;
        for (int i = arr.length-1; i > 0; i--) {
            if (arr[i] == '1') {
                count++;
            }
            max = Math.max(max, count + scores[i-1]);
        }
        return max;
    }

    // after opt
    public int maxScore(String s) {
        char[] arr = s.toCharArray();
        int count1 = 0;
        for (char c : arr) {
            if (c == '1')
                count1++;
        }
        int max = 0, count0 = 0;
        for (int i = 0; i < arr.length-1; i++) {
            if (arr[i] == '0')
                count0++;
            else
                count1--;
            max = Math.max(max, count0 + count1);
        }
        return max;
    }


    // submission method!
    // score = currentzeros - currentones(left side ones) + total ones
    public int maxScore2(String s) {

        int ones = 0;
        int zeros = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '0') {
                zeros++;
            } else {
                ones++;
            }
            if (i < s.length() - 1) {
                max = Math.max(max, zeros - ones);
            }
        }
        return max + ones;
    }
}

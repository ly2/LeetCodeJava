public class slowestKey1629 {

    public char slowestKey(int[] releaseTimes, String keysPressed) {
        char c = (char)0;
        int max_d = 0;
        int prev = 0;
        for (int i = 0; i < releaseTimes.length; i++) {
            int duration = releaseTimes[i] - prev;
            prev = releaseTimes[i];
            if (max_d < duration) {
                max_d = duration;
                c = keysPressed.charAt(i);
            } else if (max_d == duration && keysPressed.charAt(i) > c) {
                c = keysPressed.charAt(i);
            }

        }
        return c;
    }


    // less space!
    public char slowestKey2(int[] releaseTimes, String keysPressed) {
        int n = releaseTimes.length;
        int maxDifference = releaseTimes[0];
        char bestChar = keysPressed.charAt(0);
        for (int i = 1; i < n; i++) {
            int difference = releaseTimes[i] - releaseTimes[i-1];

            if (difference > maxDifference ||
                    (difference == maxDifference && keysPressed.charAt(i) > bestChar)) {
                maxDifference = difference;
                bestChar = keysPressed.charAt(i);
            }
        }
        return bestChar;
    }

}

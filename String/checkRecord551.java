public class checkRecord551 {

    public boolean checkRecord(String s) {
        int a = 0, l = 0;
        for (char c : s.toCharArray()) {
            if (c == 'A') {
                a++;
                if (a > 1)
                    return false;
            } else if (c == 'L') {
                l ++;
                if (l > 2)
                    return false;
            } else {
                l = 0;
            }
        }

        return true;
    }
}

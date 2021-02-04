public class judgeCircle657 {

    public boolean judgeCircle(String moves) {
        int hor = 0, ver = 0;
        for (char ch : moves.toCharArray()) {
            if (ch == 'U')
                ver++;
            if (ch == 'D')
                ver--;
            if (ch == 'L')
                hor--;
            if (ch == 'R')
                hor++;
        }
        return hor == 0 && ver == 0;
    }
}

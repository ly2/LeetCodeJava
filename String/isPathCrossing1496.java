import java.util.HashSet;

public class isPathCrossing1496 {


    public boolean isPathCrossing(String path) {
        int x = 0, y = 0;
        HashSet<String> set = new HashSet<>();
        set.add("00");
        for (char c : path.toCharArray()) {
            if (c == 'N')
                y++;
            else if (c == 'S')
                y--;
            else if (c == 'W')
                x--;
            else
                x++;
            StringBuilder sb = new StringBuilder();
            String coor = sb.append(x).append(y).toString();
            if (set.contains(coor))
                return true;
            set.add(coor);
        }
        return false;
    }

    // submission 0 ms method, ITS WRONG!!!!
    // if the input is "EENWS", the output should be true but it is false!
//    public boolean isPathCrossing(String path) {
//        int upDown = 0;
//        int leftRight = 0;
//        Stack<Character> stack = new Stack<>();
//
//        for (int i = 0; i < path.length(); i++) {
//            char ch = path.charAt(i);
//            if (ch == 'N') {
//                upDown--;
//            }
//            if (ch == 'S') {
//                upDown++;
//            }
//            if (ch == 'E') {
//                leftRight++;
//            }
//            if (ch == 'W') {
//                leftRight--;
//            }
//            if (upDown == 0 && leftRight == 0) {
//                return true;
//            }
//            if (!stack.isEmpty()) {
//                if (ch == 'N' && stack.peek() == 'S') {
//                    return true;
//                }
//                if (ch == 'S' && stack.peek() == 'N') {
//                    return true;
//                }
//                if (ch == 'E' && stack.peek() == 'W') {
//                    return true;
//                }
//                if (ch == 'W' && stack.peek() == 'E') {
//                    return true;
//                }
//            }
//            stack.push(ch);
//        }
//
//        return false;
//    }
}

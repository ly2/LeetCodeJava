import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

public class makeGood1544 {


    // original
    public String makeGood1(String s) {

        LinkedList<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++ ) {
            if (stack.isEmpty()) {
                stack.push(s.charAt(i));
            } else {
                if (Math.abs(s.charAt(i) - stack.peek()) == 32) {
                    stack.pop();
                } else {
                    stack.push(s.charAt(i));
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = stack.size()-1; i>=0;i--) {
            sb.append(stack.get(i));
        }

        return sb.toString();
    }

    // much faster and smaller runtime memory!
    public String makeGood(String s) {
        char[] chs = s.toCharArray();
        int index = -1;
        for (int i =0; i < s.length(); i++ ) {
            if (index>= 0 && Math.abs(chs[index] - chs[i]) == 32) {
                index--;
            } else {
                chs[++index] = chs[i];
            }
        }
        if (index < 0)
            return "";

        return new String(Arrays.copyOf(chs, index+1));
    }

    // submission method!
    public String makeGood3(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (sb.length() != 0 && (sb.charAt(sb.length() - 1) ^ 32) == s.charAt(i)) {
                sb.deleteCharAt(sb.length() - 1);
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}

import java.util.Stack;

/**
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 */
public class ValidParentheses20 {

    /**
     *  in the code,
     *  determine what bracket the charAt(i) is firstly can run the function faster than others. 1ms > 4ms
     * @param s
     * @return boolean
     */
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '{'  || s.charAt(i) == '[' ) {
                stack.push(s.charAt(i));
            } else if (s.charAt(i) == ')') {
                if (!stack.empty()&&stack.peek()=='(')
                    stack.pop();
                else
                    return false;
            } else if (s.charAt(i) == ']') {
                if (!stack.empty()&&stack.peek()=='[')
                    stack.pop();
                else
                    return false;
            } else if (s.charAt(i) == '}') {
                if (!stack.empty()&&stack.peek()=='{')
                    stack.pop();
                else
                    return false;
            }
        }
        return stack.empty();
    }

}

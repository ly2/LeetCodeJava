import java.util.LinkedList;
import java.util.Stack;

public class calculate227 {

    // without stack
    public int calculate(String s) {
        if (s == null || s.isEmpty()) return 0;
        int length = s.length();
        int currentNumber = 0, lastNumber = 0, result = 0;
        char operation = '+';
        for (int i = 0; i < length; i++) {
            char currentChar = s.charAt(i);
            if (Character.isDigit(currentChar)) {
                currentNumber = (currentNumber * 10) + (currentChar - '0');
            }
            if (!Character.isDigit(currentChar) && !Character.isWhitespace(currentChar) || i == length - 1) {
                if (operation == '+' || operation == '-') {
                    result += lastNumber;
                    lastNumber = (operation == '+') ? currentNumber : -currentNumber;
                } else if (operation == '*') {
                    lastNumber = lastNumber * currentNumber;
                } else if (operation == '/') {
                    lastNumber = lastNumber / currentNumber;
                }
                operation = currentChar;
                currentNumber = 0;
            }
        }
        result += lastNumber;
        return result;
    }

    // much clean , use the stack!
    // do not need to parse the mul div, integer and plus minus individually
    public int calculateOfficial(String s) {

        if (s == null || s.isEmpty()) return 0;
        int len = s.length();
        Stack<Integer> stack = new Stack<Integer>();
        int currentNumber = 0;
        char operation = '+';
        for (int i = 0; i < len; i++) {
            char currentChar = s.charAt(i);
            if (Character.isDigit(currentChar)) {
                currentNumber = (currentNumber * 10) + (currentChar - '0');
            }
            if (!Character.isDigit(currentChar) && !Character.isWhitespace(currentChar) || i == len - 1) {
                if (operation == '-') {
                    stack.push(-currentNumber);
                }
                else if (operation == '+') {
                    stack.push(currentNumber);
                }
                else if (operation == '*') {
                    stack.push(stack.pop() * currentNumber);
                }
                else if (operation == '/') {
                    stack.push(stack.pop() / currentNumber);
                }
                operation = currentChar;
                currentNumber = 0;
            }
        }
        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        return result;
    }

    // original 11 ms	45.3 MB
    int idx;
    public int calculate1(String s) {
        idx = 0;
        LinkedList<Integer> stack = new LinkedList<>();
        while (idx < s.length()) {
            char c = s.charAt(idx);
            if (Character.isDigit(c)) {
                stack.push(parseInt(s));
                continue;
            } else if (c == '-') {
                stack.push(Integer.MIN_VALUE);
            } else if (c == '+') {
                stack.push(Integer.MAX_VALUE);
            } else if (c == '*') {
                int num = parseInt(s);
                stack.push(stack.pop()*num);
                continue;
            } else if (c == '/') {
                int num = parseInt(s);
                stack.push(stack.pop()/num);
                continue;
            }
            idx++;

        }
        int ans = stack.pollLast();
        while (!stack.isEmpty()) {
            int x = stack.pollLast();
            if (x == Integer.MAX_VALUE) {
                ans += stack.pollLast();
            } else if (x == Integer.MIN_VALUE) {
                ans -= stack.pollLast();
            }
        }
        return ans;

    }

    private int parseInt(String s) {
        while (idx < s.length()) {
            if (Character.isDigit(s.charAt(idx))) {
                int num = 0;
                while (idx < s.length() && Character.isDigit(s.charAt(idx))) {
                    num = num * 10 + s.charAt(idx) - '0';
                    idx++;
                }
                return num;
            }
            idx++;
        }
        return 0;
    }

    // Memory Limit Exceeded
    public int calculate2(String s) {
        for (int i = s.length()-1; i >= 0; i--) {
            if (s.charAt(i) == '+') {
                return calculate2(s.substring(0, i)) + cal_mul_div(s.substring(i+1));
            }
            if (s.charAt(i) == '-') {
                return calculate2(s.substring(0, i)) - cal_mul_div(s.substring(i+1));
            }
        }
        return cal_mul_div(s);
    }

    private int cal_mul_div( String s) {
        int idx = 0;
        int num1 = 0;
        char op = '?';
        while (idx < s.length() ) {
            char c = s.charAt(idx);
            if (Character.isDigit(c)) {
                int num2 = 0;
                while (idx < s.length() && Character.isDigit(s.charAt(idx))) {
                    num2 = num2*10 + s.charAt(idx)-'0';
                    idx++;
                }
                if (op == '?')
                    num1 = num2;
                else if (op == '*') {
                    num1 *= num2;
                } else
                    num1 /= num2;
                continue;
            } else if (c == '*') {
                op = '*';
            } else if (c == '/') {
                op = '/';
            }
            idx++;
        }

        return num1;
    }


}

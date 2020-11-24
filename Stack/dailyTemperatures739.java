import java.util.Stack;

public class dailyTemperatures739 {


    public int[] dailyTemperatures(int[] T) {
        int[] ans = new int[T.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < T.length; i++) {
            while (!stack.empty() && T[i] > T[stack.peek()]) {
                ans[stack.peek()] = i-stack.peek();
                stack.pop();
            }

            if (i != T.length-1) {
                if (T[i + 1] > T[i]) {
                    ans[i] = 1;
                } else {
                    stack.push(i);
                }
            }
        }


        return ans;
    }


    //official ans
//    public int[] dailyTemperatures(int[] T) {
//        int[] ans = new int[T.length];
//        Stack<Integer> stack = new Stack();
//        for (int i = T.length - 1; i >= 0; --i) {
//            while (!stack.isEmpty() && T[i] >= T[stack.peek()]) stack.pop();
//            ans[i] = stack.isEmpty() ? 0 : stack.peek() - i;
//            stack.push(i);
//        }
//        return ans;
//    }
}

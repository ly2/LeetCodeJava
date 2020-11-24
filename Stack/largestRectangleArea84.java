import java.util.Stack;

public class largestRectangleArea84 {


    //official
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        Stack<int[]> stack = new Stack<>(); // list of pair: [index, height]

        for (int i = 0; i < heights.length; i++) {
            int start = i;

            while (!stack.empty() && stack.peek()[1] > heights[i]) {
                int height = stack.peek()[1];
                int width = i - stack.peek()[0];

                maxArea = Math.max(maxArea, height * width);
                start = stack.peek()[0];
                stack.pop();
            }
            stack.push(new int[]{start, heights[i]});
        }
        for (int i = 0; i < stack.size(); i++) {
            int height = stack.get(i)[1], start = stack.get(i)[0];
            int area = height * (heights.length - start);
            maxArea = Math.max(area, maxArea);
        }
        return maxArea;
    }
}

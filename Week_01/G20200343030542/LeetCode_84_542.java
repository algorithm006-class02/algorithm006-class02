import java.util.Stack;

public class LargestRectangleInHistogram {

    public int largestRectangleArea(int[] heights) {

        return largestRectangleAreaByStack(heights);
    }



    private int largestRectangleAreaByStack(int[] height) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            while (stack.peek() != -1 && height[stack.peek()] >= height[i]) {
                max = Math.max(max, height[stack.pop()] * (i - stack.peek() - 1));
            }
            stack.push(i);
        }
        while (stack.peek() != -1) {
            max = Math.max(max, height[stack.pop()] * (height.length - stack.peek() - 1));
        }
        return max;
    }
}
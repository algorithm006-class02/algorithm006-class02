class Solution {
    public int trap(int[] height) {
        if (height == null || height.length <= 2) {
            return 0;
        }
        
        Stack<Integer> stack = new Stack<>();
        int sum = 0;
        
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int lastIndex = stack.pop();
                
                if (stack.isEmpty()) {
                    break;
                } else {
                    sum += (Math.min(height[stack.peek()], height[i]) - height[lastIndex]) * (i - stack.peek() - 1);
                }
                
            }
            stack.push(i);
        }
        
        return sum;   
        
    }
}

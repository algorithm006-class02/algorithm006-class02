import java.util.Stack;
/*
 * @lc app=leetcode.cn id=42 lang=java
 *
 * [42] 接雨水
 */

// @lc code=start
class Solution {
    public int trap(int[] height) {
        int sum = 0;
        Stack<Integer> stack = new Stack<Integer>();
        int count = 0;
        while(count < height.length){
            while(!stack.isEmpty() && height[count] > height[stack.peek()]){
                int h = height[stack.peek()];
                stack.pop();
                if(stack.isEmpty()){
                    break;
                }
                int distance = count  - stack.peek() - 1;
                int minHeight = Math.min(height[count], height[stack.peek()]);
                sum += distance * (minHeight - h);
            }
            stack.push(count);
            count++;
        }
        return sum;
    }
}
// @lc code=end


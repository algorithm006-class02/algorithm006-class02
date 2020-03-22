import java.util.Stack;

/** https://leetcode-cn.com/problems/trapping-rain-water/submissions/
 *  先确定边界，如果当前索引对应的值小于栈顶，压栈；
 *              反之，弹栈（如果当前栈为空，则表示无边界，跳出本次循环）后，
 *              并计算出当前索引和栈顶处元素之间的积水面积。
 */
public class RainwaterCollection {
    public int trap(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int area = 0;
        for (int i = 0; i < height.length; i++) {
            //只有height[i]>栈顶时，才弹栈，并依次查看height[i]与新的栈顶之间是否存在水
            while(!stack.isEmpty()&&height[stack.peek()]<height[i]){
                int oldHeight = height[stack.peek()];
                stack.pop();
                //如果此时栈为空，则跳出，表明无界限
                if(stack.isEmpty()){
                    break;
                }
                int index = stack.peek();
                int distance = i-index-1;
                int minHeight = Math.min(height[index],height[i]);
                area += distance*(minHeight-oldHeight);
            }
            stack.push(i);

        }
        return area;

    }
}

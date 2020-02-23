package Week_01.G20200343030414;

import java.util.Stack;

/**
 * @author Xinshuai
 * @description
 * @since 2020-02-16 22:54
 */
public class LeetCode_42_414 {


    /**
     * 1、利用栈解决
     * <p>
     *     1> 当前栈为空或高度小于栈顶高度，游标入栈，当前高度游标右移
     *     2> 当前栈非空且高度大于栈顶高度，游标出栈，计算当前柱子与栈顶之间柱子的积水面积
     *     3> 重复步骤1>、>2
     */
    public int trap(int[] height) {
        int area = 0;
        Stack<Integer> stack = new Stack<>();
        int cursor = 0;
        while (cursor < height.length) {
            // 当前栈非空且高度大于栈顶高度
            while (!stack.empty() && height[cursor] > height[stack.peek()]) {
                int h = height[stack.peek()]; // 计算即将出栈柱子高度
                stack.pop(); // 游标出栈
                if (stack.empty()) { // 栈空就结束
                    break;
                }
                int distance = cursor - stack.peek() - 1; // 两个柱子（当前游标与栈顶游标）之间的宽度
                int min = Math.min(height[stack.peek()], height[cursor]); // 计算当前游标和栈顶游标的最低高度
                area = area + distance * (min - h); // 计算两个柱子之间可积水面积，并累加到已有积水面积上
            }
            stack.push(cursor); // 当前栈为空或高度小于栈顶高度，游标入栈
            cursor++; // 当前游标右移
        }
        return area;
    }
}

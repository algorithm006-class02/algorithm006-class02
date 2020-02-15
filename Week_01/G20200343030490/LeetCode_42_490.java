import java.util.Stack;

/**
 * @author:
 * @Date: 2020-02-15 17:55
 * @Copyright: 2019 www.lenovo.com Inc. All rights reserved.
 */
//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
//
//
//
// 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Mar
//cos 贡献此图。
//
// 示例:
//
// 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
//输出: 6
// Related Topics 栈 数组 双指针

public class LeetCode_42_490 {

    public static int trap(int[] height) {
        int sum = 0;
        Stack<Integer> stack = new Stack<>();
        int current = 0;
        while(current < height.length) {
            while (!stack.isEmpty() && height[stack.peek()] < height[current]) {
                //最低处高度
                int minHight = height[stack.pop()];
                //如果左边界每值结束有边界的计算
                if(stack.empty()) {
                    break;
                }
                int distance = current - stack.peek() -1 ;
                int min = Math.min(height[stack.peek()],height[current]);
                sum += distance * (min - minHight);

            }
            stack.push(current);
            current++;
        }
        return sum;
    }
}

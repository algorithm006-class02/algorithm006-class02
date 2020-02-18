import java.util.Stack;

/**
 * @Author ：zhenghaoran.
 * @Description： 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 */
public class LeetCode_42_022 {
    /**
     * 方法一 暴力法，第一次做这个题我也没有思路看下题解，意思就是大循环从[1,n-2]因为只有高低高3个连在一起他中间才有水坑
     * 每次都去找从当前点到最左边的最大值和最右边的最大值，说明他们可能存在水坑，两个取最小值然后在减去本身的高度就是当前坐标的蓄水量
     * 时间复杂度O(n^2)
     *
     * @param height
     * @return
     */
    public int trap(int[] height) {
        int count = 0;
        for (int i = 1; i < height.length - 1; i++) {
            int maxleft = 0;
            int maxright = 0;
            for (int j = i; j >= 0; j--) {
                maxleft = Math.max(maxleft, height[j]);
            }
            for (int k = i; k < height.length; k++) {
                maxright = Math.max(maxright, height[k]);
            }
            count += Math.min(maxleft, maxright) - height[i];
        }
        return count;
    }

    /**
     * 方法二用的就是动态规划，简单来说就是用空间换时间，在方法一中我们重复的计算了很多次左边右边的最大值
     * 这次我们把每个位置算出来的最大值都记录下来拿前一个去比较然后存一下下次在计算ans的时候直接拿来用
     * @param height
     * @return
     */
    public int trap2(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int ans = 0;
        int size = height.length;
        int[] left_max = new int[size];
        int[] right_max = new int[size];
        left_max[0] = height[0];
        for (int i = 1; i < size; i++) {
            left_max[i] = Math.max(height[i], left_max[i - 1]);
        }
        right_max[size - 1] = height[size - 1];
        for (int i = size - 2; i >= 0; i--) {
            right_max[i] = Math.max(height[i], right_max[i + 1]);
        }
        for (int i = 1; i < size - 1; i++) {
            ans += Math.min(left_max[i], right_max[i]) - height[i];
        }
        return ans;
    }

    /**
     * 方法三是使用栈，
     * 原理是当前高度小于栈顶元素高度则入栈
     * 大于高度，则弹出栈顶元素，然后再次跟栈顶元素进行计算长和宽计算水量
     * @param height
     * @return
     */
    public int trap3(int[] height) {
        Stack<Integer> stack = new Stack();
        int sum = 0;
        int cur = 0;
        while(cur < height.length){
            while(!stack.empty() && height[cur] > height[stack.peek()]){
                int h = height[stack.peek()];
                stack.pop();
                if(stack.empty()){
                    break;
                }
                int distance = cur - stack.peek() -1;
                int min = Math.min(height[cur],height[stack.peek()]);
                sum += (min - h) * distance;
            }
            stack.push(cur++);
        }
        return sum;

    }
}

package Week_01.G20200343030492;
import java.util.*;
/**
 * LeetCode_42_492
 */
public class LeetCode_42_492 {

	/**
	 * 动态规划，按列求和。
	 * @param height
	 * @return
	 */
	public int trap(int[] height) {
        int[] maxLefts = new int[height.length];
        int[] maxRights = new int[height.length];
        int sum = 0;
        for (int i = 1; i < height.length - 1; i++ ) {
            maxLefts[i] = Math.max(maxLefts[i - 1], height[i - 1]);
        }
        for (int i = height.length - 2; i > 0; i--) {
            maxRights[i] = Math.max(maxRights[i + 1], height[i + 1]);
        }
        for (int i = 1; i < height.length - 1; i++ ) {
            int min = Math.min(maxLefts[i], maxRights[i]);
            if (min > height[i]) {
                sum += (min - height[i]);
            }
        }
        return sum;
	}
	
	/**
	 * 使用栈。
	 * @param height
	 * @return
	 */
	public int trap1(int[] height) {
        Stack<Integer> s = new Stack<>();
        int current = 0;
        int sum = 0;
        while (current < height.length) {
            while (!s.isEmpty() && height[current] > height[s.peek()]) {
                int h = height[s.pop()];
                if (s.isEmpty()) {
                    break;
                }
                int min = Math.min(height[current], height[s.peek()]);
                int distance = current - s.peek() - 1;
                sum += distance * (min - h);
            }
            s.push(current);
            current++;
        }
        return sum;
    }
}
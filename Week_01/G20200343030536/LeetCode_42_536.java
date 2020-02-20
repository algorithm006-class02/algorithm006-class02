/**
 * @author : Hyuk
 * @description : LeetCode_42_536
 * @date : 2020/2/15 7:13 下午
 */
public class LeetCode_42_536 {

    public int trap(int[] height) {
        if (height == null || height.length < 3) {
            return 0;
        }

        int res = 0 , left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    res += leftMax - height[left];
                }
                left++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    res += rightMax - height[right];
                }
                right--;
            }
        }
        return res;
    }
}

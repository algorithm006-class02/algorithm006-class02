public class LeetCode_41_442 {
    public int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int lMax = 0, rMax = 0;
        int res = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                if (lMax > height[left]) {
                    res += lMax - height[left];
                } else {
                    lMax = height[left];
                }
                left++;
            } else {
                if (rMax > height[right]) {
                    res += rMax - height[right];
                } else {
                    rMax = height[right];
                }
                right--;
            }
        }
        return res;
    }
}

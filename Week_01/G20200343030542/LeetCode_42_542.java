public class TrappingRainWater {

    public int trap(int[] height) {
        //return trapByBruteForce(height);
        return trapBySimple(height);
    }

    private int trapBySimple(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int sum = 0;
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];
        leftMax[0] = height[0];
        for (int i = 1; i < height.length; i++) {
            leftMax[i] = Math.max(height[i], leftMax[i - 1]);
        }
        rightMax[height.length - 1] = height[height.length - 1];
        for (int i = height.length - 2; i >= 0; i--) {
            rightMax[i] = Math.max(height[i], rightMax[i + 1]);
        }
        for (int i = 0; i < height.length; i++) {
            int min = Math.min(leftMax[i], rightMax[i]);
            if (min > height[i]) {
                sum += min - height[i];
            }
        }
        return sum;
    }

    private int trapByBruteForce(int[] height) {
        int sum = 0;
        for (int i = 1; i < height.length; i++) {
            int left_max = 0;
            for (int j = i - 1; j >= 0; j--) {
                left_max = Math.max(left_max, height[j]);
            }
            int right_max = 0;
            for (int j = i + 1; j < height.length; j++) {
                right_max = Math.max(right_max, height[j]);
            }
            int min = Math.min(left_max, right_max);
            if (min > height[i]) {
                sum += min - height[i];
            }
        }
        return sum;
    }


}
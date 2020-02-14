/**
 * 42.接雨水
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 */
public class TrappingRainWater {
    public static void test() {
//        int[] nums = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int[] nums = new int[]{4, 2, 3};
        TrappingRainWater rainWater = new TrappingRainWater();
        System.out.println("water:" + rainWater.trap2(nums));
    }

    public int trap(int[] height) {
        // 暴力法：对除两端外的每一个柱子的储水量进行求和
        // 只要当前柱子不是最高的，且它不位于最左端或最右端，它就可能有水；
        // 当前柱子的水量由它两边最高的柱子高度决定，即如果两边的柱子都大于当前柱子，它就一定有水
        int capacity = 0;
        for (int i = 1; i < height.length - 1; i++) {
            int maxLeft = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (height[j] > maxLeft) {
                    maxLeft = height[j];
                }
            }

            int maxRight = 0;
            for (int j = i + 1; j < height.length; j++) {
                if (height[j] > maxRight) {
                    maxRight = height[j];
                }
            }

            int min = Math.min(maxLeft, maxRight);
            if (min > height[i]) {
                capacity += (min - height[i]);
            }
        }
        return capacity;
    }

    public int trap2(int[] height) {
        // 双循环优化版——缓存所有柱子两边的最大值（动态规划）
        // trap1中已经分析过，当前柱子的储水量由它两边最高的柱子高度决定
        int[] maxLefts = new int[height.length];
        int[] maxRights = new int[height.length];
        for (int i = 1; i < height.length - 1; i++) {
            maxLefts[i] = Math.max(height[i - 1], maxLefts[i - 1]);
        }
        for (int i = height.length - 2; i >= 0; i--) {
            maxRights[i] = Math.max(height[i + 1], maxRights[i + 1]);
        }

        int capacity = 0;
        for (int i = 1; i < height.length - 1; i++) {
            int min = Math.min(maxLefts[i], maxRights[i]);
            if (min > height[i]) {
                capacity += (min - height[i]);
            }
        }
        return capacity;
    }

    public int trap3(int[] height) {
        // 双指针法
        int maxLeft = 0;
        int[] maxRights = new int[height.length];
        for (int i = height.length - 2; i >= 0; i--) {
            maxRights[i] = Math.max(maxRights[i + 1], height[i + 1]);
        }
        int capacity = 0;
        for (int i = 1; i < height.length - 1; i++) {
            maxLeft = Math.max(maxLeft, height[i - 1]);
            int min = Math.min(maxLeft, maxRights[i]);
            if (min > height[i]) {
                capacity = capacity + (min - height[i]);
            }
        }
        return capacity;
    }

    public int trap4(int[] height) {
        // 双指针优化法-一次遍历
        int capacity = 0;
        int maxLeft = 0;
        int maxRight = 0;
        for (int i = 0, j = height.length - 1; i < j; ) {
            maxLeft = Math.max(maxLeft, height[i]);
            maxRight = Math.max(maxRight, height[j]);
            if (maxLeft < maxRight) {
                capacity += maxLeft - height[i++];
            } else {
                capacity += maxRight - height[j--];
            }
        }
        return capacity;
    }
}

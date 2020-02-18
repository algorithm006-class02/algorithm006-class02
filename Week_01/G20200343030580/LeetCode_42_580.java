class Solution {
    public int trap(int[] height) {
        int len = height.length;
        int nextIndex = 0;
        int nextPreIndex = 0;
        int water = 0;
        for (int i = 0, j = len - 1; i < j; ) {
            if (nextIndex != -1) {
                nextIndex = findNextHighIndex(height, i, j);
            }
            if (nextPreIndex != -1) {
                nextPreIndex = findPreHightIndex(height, i, j);
            }
            if (nextIndex == j && nextPreIndex == i) {
                water += count(height, i, nextIndex, true);
            } else {
                water += count(height, i, nextIndex, true);
                water += count(height, nextPreIndex, j, false);
            }
            if (nextIndex != -1) {
                i = nextIndex;
            }
            if (nextPreIndex != -1) {
                j = nextPreIndex;
            }
        }
        return water;
    }

    private int findNextHighIndex(int[] nums, int startIndex, int endIndex) {
        for (int i = startIndex + 1; i <= endIndex; i++) {
            if (nums[i] >= nums[startIndex]) {
                return i;
            }
        }
        return -1;
    }

    private int findPreHightIndex(int[] nums, int startIndex, int endIndex) {
        for (int i = endIndex - 1; i >= startIndex; i--) {
            if (nums[i] >= nums[endIndex]) {
                return i;
            }
        }
        return -1;
    }

    private int count(int[] nums, int startIndex, int endIndex, boolean left) {
        if (startIndex < 0 || endIndex < 0) {
            return 0;
        }
        if (endIndex - startIndex == 1) {
            return 0;
        } else {
            int base = left ? nums[startIndex] : nums[endIndex];
            int water = 0;
            for (int i = startIndex + 1; i < endIndex; i++) {
                water += base - nums[i];
            }
            return water;
        }
    }
}
//寻找下一个不为0的元素
class Solution {
    public void moveZeroes(int[] nums) {
        int nextNoZerOIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nextNoZerOIndex > nums.length - 1) {
                nums[i] = 0;
                continue;
            }

            if (nums[nextNoZerOIndex] == 0) {
                for (int j = nextNoZerOIndex + 1; j < nums.length; j++) {
                    if (nums[j] != 0) {
                        nextNoZerOIndex = j;
                        break;
                    }
                }
            }
            nums[i] = nums[nextNoZerOIndex];
            nextNoZerOIndex++;
        }
    }
}
//1.暴力模式 挨个找最大值

class Solution {
    public int removeDuplicates(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (i == nums.length - 1) {
                return nums.length;
            }
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] > nums[i]) {
                    nums[i + 1] = nums[j];
                    break;
                }
                if (j == nums.length - 1) {
                    return i + 1;
                }
            }
        }
        return 0;
    }
}

//模仿最优解 双指针
class Solution {
    public int removeDuplicates(int[] nums) {
        int index = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[index]) {
                index++;
                nums[index] = nums[i];
            }
        }
        return index + 1;
    }
}
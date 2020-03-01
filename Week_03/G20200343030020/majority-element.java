//暴力
class Solution {
    public int majorityElement(int[] nums) {
        int majorCount = nums.length / 2;
        for (int num : nums) {
            int count = 0;
            for (int ele : nums) if (ele == num) count += 1;
            if (count > majorCount) return num;
        }
        return -1;
    }
}

class Solution {
    public int majorityElement(int[] nums) {
        int major = nums[0], count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                count++;
                major = nums[i];
            } else if (major == nums[i]) {
                count++;
            } else count--;
        }
        return major;
    }
}
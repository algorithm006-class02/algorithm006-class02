class Solution {
    public int jump(int[] nums) {
        int length = nums.length, next = 0, count = 1;
        if (length == 1) {
            return 0;
        }
        while (next + nums[next] < length - 1) {
            int value = nums[next];
            int currentNext = next;
            int maxJump = 0;
            for (int i = 1; i <= value; i++) {
                if (nums[currentNext + i] + currentNext + i > maxJump) {
                    maxJump = nums[currentNext + i] + currentNext + i;
                    next = currentNext + i;
                }
            }
            count++;
        }
        return count;
    }
}
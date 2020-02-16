class Solution {
    public void rotate(int[] nums, int k) {
        int tmp, pre;
        for (int i = 0; i < k; i++) {
            pre = nums[nums.length - 1];
            for (int j = 0; j < nums.length; j++) {
                tmp = nums[j];
                nums[j] = pre;
                pre = tmp;
            }
        }
    }
}

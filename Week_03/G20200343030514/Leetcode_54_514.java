class Solution {
    // greedy
    public int jump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int count = 0;
        int end = 0;
        int maxPosition = 0;
        // i < nums.length - 1 <= i == nums.length - 1 其实已经结束了
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] + i > maxPosition) {
                maxPosition = nums[i] + i;
            }
            
            if (i == end) {
                end = maxPosition;
                count++;
            }
            
        }
        
        return count;
        
    }
}

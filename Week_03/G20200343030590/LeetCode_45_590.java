public class LeetCode_45_590 {

    // The idea of greedy algorithm is to pick locally optimal move at each step, that will lead to globally optimal solution.
    // One couldn't reach index i if the maximum position that one could reach starting from the previous cells is less than i. Unreachable index i <= n -1 means that the last index is unreachable as well.
    public int jump(int[] nums) {
        int n = nums.length;
        if (n < 2) return 0;

        // max position one could reach
        // starting from index <= i
        int maxPos = nums[0];
        // max number of steps one could do
        // inside this jump
        int maxSteps = nums[0];

        int jumps = 1;
        for (int i = 1; i < n; ++i) {
            // if to reach this point
            // one needs one more jump
            if (maxSteps < i) {
                ++jumps;
                maxSteps = maxPos;
            }
            maxPos = Math.max(maxPos, nums[i] + i);
        }
        return jumps;
    }
}

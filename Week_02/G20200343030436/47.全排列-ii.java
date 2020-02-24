/*
 * @lc app=leetcode.cn id=47 lang=java
 *
 * [47] 全排列 II
 */

// @lc code=start
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }
        Arrays.sort(nums);
        boolean[] used = new boolean[len];
        Deque<Integer> path = new ArrayDeque<>(len);//Java建议使用的栈
        dfs(nums, len, 0, used, path, res);
        return res;
    }

    private void dfs(int[] nums, int len, int depth, boolean[] used, Deque<Integer> stack, List<List<Integer>> res) {
        if (depth == len) {
            res.add(new ArrayList<Integer>(stack));
            return;
        }
        for (int i = 0; i < len; i++) {
            if (used[i] == false) {
                if (i > 0 && nums[i - 1] == nums[i] && used[i - 1] == false) {
                    continue;
                }
                used[i] = true;
                stack.addLast(nums[i]);
                dfs(nums, len, depth + 1, used, stack, res);
                //回溯 撤销选择
                stack.removeLast();
                used[i] = false;
            }
        }
    }
}
// @lc code=end


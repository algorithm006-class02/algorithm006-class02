package Week_02.G20200343030414;

import java.util.*;

/**
 * @author Xinshuai
 * @description 题目链接：https://leetcode-cn.com/problems/permutations-ii/
 * @since 2020-02-23 21:05
 */
public class LeetCode_47_414 {


    /**
     * dfs + 剪枝
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        int numsLen = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (numsLen == 0) {
            return res;
        }
        // 为了剪枝方便，做排序处理
        Arrays.sort(nums);
        boolean[] used = new boolean[numsLen];
        Deque<Integer> stack = new ArrayDeque<>(numsLen);
        dfs(nums, numsLen, 0, used, stack, res);
        return res;
    }

    private void dfs(int[] nums, int numsLen, int depth, boolean[] used,
                     Deque<Integer> stack, List<List<Integer>> res) {
        if (depth == numsLen) {
            res.add(new ArrayList<>(stack));
            return;
        }
        for (int i = 0; i < numsLen; i++) {
            if (!used[i]) {
                if (i > 0 && nums[i - 1] == nums[i] && !used[i - 1]) {
                    continue;
                }
                used[i] = true;
                stack.addLast(nums[i]);
                dfs(nums, numsLen, depth + 1, used, stack, res);
                // 回溯
                stack.removeLast();
                used[i] = false;
            }
        }
    }

}

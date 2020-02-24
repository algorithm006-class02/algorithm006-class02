import java.util.List;

/*
 * @lc app=leetcode.cn id=46 lang=java
 *
 * [46] 全排列
 */

// @lc code=start
class Solution {
    // 回溯 思路 使用整数索引作为参数backtrack(frist)
    // 遍历索引first 到索引 n -1 所有整数
    // 排列中放置i个整数swap（nums【first】，nums【i】）
    // 继续生成从第i个整数的所有排列 backtrack(first + 1)
    // 回溯通过swap（nums【first】，nums【i】）还原状态
    // 时间复杂度 O(N!)
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> output = new LinkedList<>();
        ArrayList<Integer> num_list = new ArrayList<Integer>();
        for (int num : nums) {
            num_list.add(num);
        }
        int n = nums.length;
        backtrack(n, num_list, output, 0);
        return output;
    }

    public void backtrack(int n, ArrayList<Integer> nums, List<List<Integer>> outout, int first) {
        if (first == n) { //n表示就是到了 最底层 说明已经排列成功了一回
            outout.add(new ArrayList<Integer>(nums));
        }
        for (int i = first; i < n; i++) {
            Collections.swap(nums, first, i);
            backtrack(n, nums, outout, first + 1);//递归深入到下面的层 到最底部
            Collections.swap(nums, first, i);//回溯
        }
    }
}
// @lc code=end


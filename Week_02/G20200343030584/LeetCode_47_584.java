package week2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 47. 全排列 II
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 * <p>
 * 示例:
 * 输入: [1,1,2]
 * 输出:
 * [
 * [1,1,2],
 * [1,2,1],
 * [2,1,1]
 * ]
 * <p>
 * 链接：https://leetcode-cn.com/problems/permutations-ii
 */
public class Permutations2 {
    private List<List<Integer>> res = new ArrayList<>();
    /** 记录当前path中被遍历的元素 */
    private boolean[] used;

    public static void test() {
        int[] nums = new int[]{1, 2, 1};
        List<List<Integer>> permute = new Permutations2().permute(nums);
        for (List<Integer> list : permute) {
            System.out.println(list);
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        // 回溯法
        // 有重复的数字，第一反应是遍历的时候需要剪枝
        if (nums.length <= 0) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        used = new boolean[nums.length];
        helper(nums, new Stack());
        return res;
    }

    // https://leetcode-cn.com/problems/permutations-ii/solution/hui-su-suan-fa-python-dai-ma-java-dai-ma-by-liwe-2/
    private void helper(int[] nums, Stack<Integer> list) {
        // 终结条件
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }

        // 缓存之前访问过的值
        for (int i = 0; i < nums.length; i++) {
            // 过滤重复数字
            if (used[i]) {
                continue;
            } else if ((i > 0) && (nums[i - 1] == nums[i]) && !used[i - 1]) {
                // 已经遍历过的元素 且 前一个元素在回退的过程中不是刚被撤消选择
                continue;
            }
            used[i] = true;
            list.push(nums[i]);

            helper(nums, list);

            used[i] = false;
            list.pop();
        }
    }
}

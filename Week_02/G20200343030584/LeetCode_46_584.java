package week2;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 46. 全排列
 * <p>
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
 * <p>
 * 示例:
 * 输入: [1,2,3]
 * 输出:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 * https://leetcode-cn.com/problems/permutations/
 */
public class Permutations {
    private List<List<Integer>> res = new ArrayList<>();

    public static void test() {
        int[] nums = new int[]{1, 2, 3};
        List<List<Integer>> permute = new Permutations().permute(nums);
        for (List<Integer> list : permute) {
            System.out.println(list);
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        // 回溯法
        if (nums.length <= 0) {
            return new ArrayList<>();
        }
        helper(nums, new Stack());
        return res;
    }

    private void helper(int[] nums, Stack<Integer> list) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int num : nums) {
            // 过滤重复数字
            if (list.contains(num)) {
                continue;
            }
            list.push(num);
            helper(nums, list);
            list.pop();
        }
    }
}

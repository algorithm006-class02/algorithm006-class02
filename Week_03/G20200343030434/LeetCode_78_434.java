package algorithm.leetCode.week03.No78;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ltw
 * on 2020-03-01.
 */
class Solution {
    List<List<Integer>> result;

    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        if (nums == null) {
            return result;
        }
        generate(0, nums, new ArrayList<>(), result);
        return result;

    }

    public void generate(int level, int[] nums, List<Integer> s, List<List<Integer>> result) {
        if (level == nums.length) {
            result.add(new ArrayList<>(s));
            return;
        }
        generate(level + 1, nums, s, result); //不加
        s.add(nums[level]);
        generate(level + 1, nums, s, result); //加
        s.remove(s.size() - 1);
    }

    public static void main(String[] args) {
        int[] list = {1, 2, 3};

        Solution solution = new Solution();
        solution.subsets(list);
    }

}


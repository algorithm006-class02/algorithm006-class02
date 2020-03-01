package Week_02.G20200343030414;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Xinshuai
 * @description 题目链接：https://leetcode-cn.com/problems/permutations/
 * @since 2020-02-23 20:30
 */
public class LeetCode_46_414 {

    /**
     * 1、通过递归解决
     */
    public List<List<Integer>> permute1(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        recursive(res, new ArrayList<>(), nums);
        return res;
    }

    private void recursive(List<List<Integer>> res, List<Integer> currList, int[] nums) {
        if (currList.size() == nums.length) {
            res.add(new ArrayList<>(currList));
        }
        for (int num : nums) {
            if (!currList.contains(num)) {
                currList.add(num);
                recursive(res, currList, nums);
                currList.remove(currList.size() - 1); // 回退
            }
        }
    }

    /**
     * 2、通过递归解决
     */
    public List<List<Integer>> permute2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0) {
            return res;
        }
        recursive2(nums, 0, new ArrayList<>(), res);
        return res;
    }

    private void recursive2(int[] nums, int start, List<Integer> currList, List<List<Integer>> res) {
        if (currList.size() == nums.length) {
            res.add(currList);
            return;
        }
        for (int i = 0; i <= currList.size(); i++) {
            List<Integer> newCurrList = new ArrayList<>(currList);
            newCurrList.add(i, nums[start]);
            recursive2(nums, start + 1, newCurrList, res);
        }
    }

}

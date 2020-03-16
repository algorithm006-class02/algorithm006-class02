import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        helper(nums, 0, new LinkedList<>(), res);
        return res;


    }

    private void helper(int[] nums, int start, List<Integer> curpath, List<List<Integer>> res) {
        res.add(new LinkedList<Integer>(curpath));
        for (int i = start; i < nums.length; i++) {
            curpath.add(nums[i]);
            helper(nums, i + 1, curpath, res);
            curpath.remove(curpath.size() - 1);
        }
    }
}
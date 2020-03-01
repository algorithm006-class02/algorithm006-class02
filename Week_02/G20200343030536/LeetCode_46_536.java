import java.util.ArrayList;
import java.util.List;

/**
 * @author : Hyuk
 * @description : LeetCode_46_536
 * @date : 2020/2/23 8:09 下午
 */
public class LeetCode_46_536 {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }

        List<Integer> tmp = new ArrayList<>();
        dfs(nums, res, tmp);
        return res;
    }

    private void dfs(int[] nums, List<List<Integer>> res, List<Integer> tmp) {
        if (tmp.size() == nums.length) {
            res.add(new ArrayList<>(tmp));
            return;
        }

        for (int i = 0, len = nums.length; i < len; ++i) {
            if (tmp.contains(nums[i])) { continue; }
            tmp.add(nums[i]);
            dfs(nums, res, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }
}

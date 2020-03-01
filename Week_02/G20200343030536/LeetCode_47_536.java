import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author : Hyuk
 * @description : LeetCode_47_536
 * @date : 2020/2/23 4:05 下午
 */
public class LeetCode_47_536 {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) { return res; }

        Arrays.sort(nums);
        List<Integer> tmp = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        dfs(nums, res, tmp, used);
        return res;
    }

    private void dfs(int[] nums, List<List<Integer>> res, List<Integer> tmp, boolean[] used) {
        if (tmp.size() == nums.length) {
            res.add(new ArrayList<>(tmp));
            return;
        }

        for (int i = 0, len = nums.length; i < len; ++i) {
            if ((i != 0 && nums[i] == nums[i - 1] && !used[i - 1]) || used[i]) {
                continue;
            }
            tmp.add(nums[i]);
            used[i] = true;
            dfs(nums, res, tmp, used);
            tmp.remove(tmp.size() - 1);
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,1,2};
        System.out.println(new LeetCode_47_536().permuteUnique(nums));
    }
}

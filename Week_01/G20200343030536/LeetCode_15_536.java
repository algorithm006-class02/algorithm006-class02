import java.util.*;

/**
 * @author : Hyuk
 * @description : LeetCode_15_536
 * @date : 2020/2/15 12:48 上午
 */
public class LeetCode_15_536 {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return result;
        }

        // 排序
        Arrays.sort(nums);
        for (int i = 0, len = nums.length; i < len; ++i) {
            for (int j = i + 1; j < len; ++j) {
                for (int k = j + 1; k < len ;++k) {
                    int value = nums[i] + nums[j] + nums[k];
                    if (value == 0) {
                        result.add(createNewResult(nums[i], nums[j], nums[k]));
                    } else if (value > 0) {
                        continue;
                    }
                }
            }
        }

        return result;
    }

    private List<Integer> createNewResult(int value1, int value2, int value3) {
        List<Integer> item = new ArrayList<>();
        item.add(value1);
        item.add(value2);
        item.add(value3);
        return item;
    }

}

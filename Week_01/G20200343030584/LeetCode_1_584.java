import java.util.HashMap;
import java.util.Map;

/**
 * 1. 两数之和
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * <p>
 * 示例:
 * <p>
 * 给定 nums = [2, 7, 11, 15], target = 9
 * <p>
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 */
public class TwoSum {
    public static void test() {
        TwoSum twoSum = new TwoSum();
        int[] nums = {1, 3, 4, 2};
        int target = 6;
        int[] ints = twoSum.twoSum3(nums, target);
        if (ints != null) {
            Utils.printArray(ints);
        } else {
            System.out.println("不存在这样的两数之和。");
        }
    }

    public int[] twoSum(int[] nums, int target) {
        // 暴力双指针法
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == target - nums[j]) {
                    int[] result = new int[2];
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return null;
    }

    public int[] twoSum2(int[] nums, int target) {
        // 哈希缓存法——两次循环
        Map<Integer, Integer> cache = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            cache.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int key = target - nums[i];
            if (cache.containsKey(key) && cache.get(key) != i) {
                return new int[]{i, cache.get(key)};
            }
        }
        return null;
    }

    public int[] twoSum3(int[] nums, int target) {
        // 哈希缓存法2 —— 一次循环
        Map<Integer, Integer> cache = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            int key = target - nums[i];
            if (cache.containsKey(key)) {
                // 小细节：缓存存在，说明之前遍历过，即这个下标比当前下标小
                return new int[]{cache.get(key), i};
            } else {
                cache.put(nums[i], i);
            }
        }
        return null;
    }
}

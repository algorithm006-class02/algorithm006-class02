/**
 *
 * 1.两数之和（简单）
 * a + b = target
 *
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。(注意)
 *
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 *
 * 思路（精简）：
 * 1.暴力法  遍历数组元素 两两比较
 *  时间复杂度 O(n^2)
 *  空间复杂度 O(1)
 *
 * 2.一遍哈希表
 * 时间复杂度：O(n)
 *
 * 空间复杂度：O(n)
 * 所需的额外空间取决于哈希表中存储的元素数量，该表最多需要存储 n 个元素。
 *
 *
 */
public class Leetcode_1_390 {

    /**
     * 1.暴力法
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSumOne(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == target - nums[i]) {
                    return new int[] { i, j };
                }
            }
        }
        return new int[2];
    }

    /**
     * 2.一遍哈希表
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSumTwo(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int number = target - nums[i];
            if(map.containsKey(number)){
                return new int[]{i,map.get(number)};
            }
            // 存入数字 以及对应下标
            map.put(nums[i],i);
        }
        return new int[2];
    }


}

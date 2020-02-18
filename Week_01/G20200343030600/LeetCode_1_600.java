/**
 1.两数之和
    一遍哈希表：
    遍历nums，将元素的目标元素和元素的下标作为Key和Value放入哈希表中，同时检查哈希表中是否存在当前元素作为Key, 若存在则返回对应解。
 */

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i])){
                return new int[] {map.get(nums[i]), i};
            }
            map.put(target - nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
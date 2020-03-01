class Solution {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == target - nums[i]) {
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}

//hash table
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int ele = target - nums[i];
            if (map.containKey(ele) && map.get(ele) != i)
                return new int[]{i, map.get(ele)};
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int ele = target - nums[i];
            if (map.containsKey(ele)) return new int[]{i, map.get(ele)};
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}

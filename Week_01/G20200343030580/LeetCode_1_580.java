class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            Integer match = map.get(target - nums[i]);
            if (match != null) {
                result[0] = match;
                result[1] = i;
                return result;
            } else {
                map.put(nums[i], i);
            }
        }
        return result;
    }
}
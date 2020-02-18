class Solution {
    public int[] twoSum(int[] nums, int target) {
        if(nums == null || nums.length < 2) return new int[0];
        int[] result = new int[2];
        Map<Integer,Integer> hm = new HashMap<Integer,Integer>();
        for (int i = 0; i < nums.length; i ++) {
            if (hm.containsKey(target - nums[i])){
                result[0] =hm.get(target - nums[i]);
                result[1] = i;
            }
            hm.put(nums[i], i);
        }
        return result;
    }
}
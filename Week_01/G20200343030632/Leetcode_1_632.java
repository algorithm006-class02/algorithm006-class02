import java.lang.Integer;
import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> res = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (res.containsKey(nums[i])) {
                return new int[] {res.get(nums[i]), i};
            } else {
                res.put(target - nums[i], i);
            }
        }
        return null;
    }
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 5};
        int target = 9;
        Solution obj = new Solution();
        int[] res =obj.twoSum(nums, target);
        System.out.println(Arrays.toString(res));


    }
}
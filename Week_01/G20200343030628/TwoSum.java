import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(16);
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            //判断是否已经包含两数之和的另一个数
            if (map.containsKey(complement)) {
                result[0] = i;
                result[1] = map.get(complement);
                break;
            }
            map.put(nums[i],i);
        }
        return result;
    }


    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        int[] nums = {2, 7, 11, 15};
        int[] sum = twoSum.twoSum(nums, 13);
        System.out.println(sum[0]+","+sum[1]);
    }

}

import java.util.HashMap;
import java.util.Map;

public class LeetCode_1_422 {
    public int[] twoSum(int[] nums, int target) {
        //map初始容量取2的幂
        Map<Integer,Integer> map=new HashMap<Integer, Integer>((int)((float) nums.length / 0.75F + 1.0F));
        //循环遍历数组
        for (int i = 0; i < nums.length; i++) {
            //如果存在这个key 就返回下标
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            //否则将该数组项的值赋值给key，下标赋值给value
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("该数组中不存在这样的两个整数，和为"+target);
    }
}

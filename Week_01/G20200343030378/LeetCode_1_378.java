import java.util.Arrays;
import java.util.HashMap;

public class LeetCode_1_378 {
    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer,Integer> hashMap = new HashMap<>();

        for (int i = 0; i < nums.length;i++){
            if(null == hashMap.get(nums[i])){
                hashMap.put(target - nums[i],i);
            }else {
                return new int[]{hashMap.get(nums[i]),i};
            }
        }
        return new int[]{};
    }
}

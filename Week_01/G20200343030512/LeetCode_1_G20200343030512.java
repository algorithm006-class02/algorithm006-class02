package Week01.G20200343030512;

//初始实现代码：
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int subcor[] = new int[2];
        for (int i = 0 ;i<nums.length ;i++){
            for (int j = i+1 ; j< nums.length;j++){
                if(nums[i] + nums[j] == target){
                    subcor[0] = i;
                    subcor[1] = j;
                    break;
                }
            }
        }
        return subcor;
    }
}
/*简单分析：
        时间复杂度 O(n^2)，空间复杂度O(1)，结果是内存使用较高，效率低；
        当没有符合条件的结果时，无返回信息
        再次实现代码
        使用一遍哈希表完成题目要求，时间复杂度O(n)，空间复杂度O(n)
*/
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i< nums.length; i++){
            map.put(nums[i],i);
        }

        for(int i = 0 ;i< nums.length; i++){
            int complement = target - nums[i];
            if(map.containsKey(complement) && map.get(complement) != i){
                return new int[]{i,map.get(complement)};

            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
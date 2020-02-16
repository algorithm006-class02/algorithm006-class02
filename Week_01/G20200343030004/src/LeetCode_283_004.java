import java.util.Arrays;

public class LeetCode_283_004 {

    // 记录0的个数，然后每个非0的数字需要向前移动的位数，就是已经记录的0的个数，最后把末尾都赋值成0
    public static String moveZeroes01(int[] nums) {
        if(nums == null || nums.length <=1) {
            return null;
        }
        int zeroCount = 0;
        for(int index = 0;index<nums.length;index++) {
            if(nums[index] == 0) {
                zeroCount++;
            } else {
                nums[index - zeroCount] = nums[index];
            }
        }
        for(int index = nums.length - zeroCount;index<nums.length;index++) {
            nums[index] = 0;
        }
        return Arrays.toString(nums);
    }

    //双指针思想
    public static String moveZeroes02(int[] nums) {
        if(nums == null || nums.length <=1) {
            return null;
        }
        int manulIndexForPutNonZero = 0;

        // 迭代原数组，遇到非0，赋值给manulIndexForPutNonZero所在位置，manulIndexForPutNonZero+1
        for(int i = 0;i<nums.length;i++) {
            if(nums[i] != 0){
                nums[manulIndexForPutNonZero] = nums[i];
                if(manulIndexForPutNonZero != i) {
                    //边界情况，[1,1]这种
                    nums[i] = 0;
                }
                manulIndexForPutNonZero++;
            }
        }
        return Arrays.toString(nums);
    }

    public static void main(String[] args) {
        int[] nums01 = new int[]{0,1,2,0,5,9,0,7};
        int[] nums02 = new int[]{1,1};
        int[] nums03 = new int[]{0,1};
        System.out.println(moveZeroes01(nums01));
        System.out.println(moveZeroes01(nums02));
        System.out.println(moveZeroes01(nums03));

        nums01 = new int[]{0,1,2,0,5,9,0,7};
        nums02 = new int[]{1,1};
        nums03 = new int[]{0,1};
        System.out.println( moveZeroes02(nums01));
        System.out.println( moveZeroes02(nums02));
        System.out.println( moveZeroes02(nums03));
    }
}

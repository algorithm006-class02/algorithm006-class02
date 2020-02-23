import java.util.Arrays;

public class LeetCode_26_004 {

    public static String removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0){
            return null;
        }
        int indexForNoRepeat = 0; // 第一个指针，用来记录从左到右 无重复部分，最右边的位置
        for (int indexForAll = 1;indexForAll < nums.length;indexForAll++) {
            if(nums[indexForNoRepeat] != nums[indexForAll]) {
                indexForNoRepeat++;
                nums[indexForNoRepeat] = nums[indexForAll];
            }
        }

        int[] printLineNums = new int[indexForNoRepeat+1];
        System.arraycopy(nums,0,printLineNums,0,indexForNoRepeat+1);
        return Arrays.toString(printLineNums);
    }

    public static void main(String[] args) {

        int[] nums01 = new int[]{0,0,0,1,1,2,3,5,7,7,7,9,9};
        int[] nums02 = new int[]{1,1};
        int[] nums03 = new int[]{0,0,0};
        int[] nums04 = new int[]{0,0,1,2,2,5,5,7,9,9,10,11,13,14,14,14,16};

        System.out.println(removeDuplicates(nums01));
        System.out.println(removeDuplicates(nums02));
        System.out.println(removeDuplicates(nums03));
        System.out.println(removeDuplicates(nums04));
    }
}

import java.util.Arrays;

public class LeetCode_189_004 {

    public static String rotate(int[] nums, int k) {
        if(nums == null || nums.length == 0) {
            return null;
        }

        if(nums.length == 1 ||  k==0) {
            return Arrays.toString(nums);
        } else {
            k = k % nums.length;

            reverseArray(nums,0,nums.length-1);
            reverseArray(nums,0,k-1);
            reverseArray(nums,k,nums.length-1);

            return Arrays.toString(nums);
        }
    }

    public static void reverseArray(int[] nums,int start,int end) {
        while(start < end) {
            int tmp = nums[end];
            nums[end] = nums[start];
            nums[start] = tmp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {

        int[] nums01 = new int[]{0,1,2,3,4,5,6,7};
        int[] nums02 = new int[]{0,1};
        int[] nums03 = new int[]{0};

        System.out.println(rotate(nums01,0));
        System.out.println(rotate(nums01,3));
        System.out.println(rotate(nums01,15));

        System.out.println(rotate(nums02,0));
        System.out.println(rotate(nums02,3));
        System.out.println(rotate(nums02,13));

        System.out.println(rotate(nums03,0));
        System.out.println(rotate(nums03,3));
        System.out.println(rotate(nums03,13));

    }
}

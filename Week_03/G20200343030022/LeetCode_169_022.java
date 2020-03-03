/**
 * @Description：169. 多数元素
 *
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。

你可以假设数组是非空的，并且给定的数组总是存在多数元素。

示例 1:

输入: [3,2,3]
输出: 3
示例 2:

输入: [2,2,1,1,1,2,2]
输出: 2

 */
public class LeetCode_169_022 {
    /**
     * 分支方法
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = new int[]{2,2,3,1,1,2,2};
        LeetCode_169_022 l = new LeetCode_169_022();

        System.out.println(l.majorityElement(arr));

    }
    public int majorityElement(int[] nums) {
        return majorityElementHelp(nums, 0, nums.length - 1);
    }

    private int majorityElementHelp(int[] nums,int l,int r){
        if(l == r){
            return nums[l];
        }

        int mid = (r - l) / 2 + l;
        int left = majorityElementHelp(nums, l, mid);
        int right = majorityElementHelp(nums, mid + 1, r);

        if(left == right){
            return left;
        }

        int leftCount = countNumber(nums, left, l, mid);
        int rightCount = countNumber(nums, right, mid + 1, r);
        return leftCount > rightCount ? left : right;

    }

    private int countNumber(int[] nums, int num, int l, int r) {
        int count = 0;
        for(int i = l;i <= r;i++){
            if(nums[i] == num){
                count ++;
            }
        }
        return count;
    }

    /**
     * 因为是众数所以最后肯定会有一个数会胜出
     * @param nums
     * @return
     */
    public int majorityElement2(int[] nums) {
        int count = 0;
        Integer candidate = null;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        return candidate;

    }

}

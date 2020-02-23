/**
 * 旋转数组
 *
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 *
 * Eg:
 * 输入: [-1,-100,3,99] 和 k = 2
 * 输出: [3,99,-1,-100]
 * 解释:
 * 向右旋转 1 步: [99,-1,-100,3]
 * 向右旋转 2 步: [3,99,-1,-100]
 *
 */
public class LeetCode_189_564 {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        int k = 3;

//        rotate1(nums, k);
//        rotate2(nums, k);
//        rotate3(nums, k);
        rotate4(nums, k);

        for (int i = 0; i < nums.length ; i++) {
            System.out.print(nums[i] + ",");
        }
    }

    /**
     * 暴力解法
     * @param nums
     * @param k
     */
    private static void rotate1(int[] nums, int k) {
        // 运用临时变量 previous 保持上一个参数，运用一个temp 进行交换，然后循环调用 K 次
        int previous , temp ;
        for (int i = 0 ; i < k ; i ++) {
            previous = nums[nums.length -1];
            for (int j = 0 ; j < nums.length ; j++) {
                temp = nums[j];
                nums[j] = previous;
                previous = temp;
            }
        }
    }

    /**
     * 运用一个额外的数组记录，但是空间复杂度为O(n)
     * @param nums
     * @param k
     */
    private static void rotate2(int[] nums, int k) {
        // 运用一个额外数组进行记录，每个参数移动的位置公式 ( i + k ) % nums.length
//        k %= nums.length;
        int[] a = new int[nums.length];
        for (int i = 0 ; i < nums.length ; i++) {
            a [( i + k ) % nums.length] = nums[i];
        }
        for (int i = 0 ; i < nums.length ; i++) {
            nums[i] = a[i];
        }
    }

    /**
     * 反转数据
     * @param nums
     * @param k
     */
    private static void rotate3(int[] nums, int k) {
        /**
         * [1,2,3,4,5,6,7] k = 3
         * 第一次反转[7,6,5,4,3,2,1]
         * 第二次反转[5,6,7,4,3,2,1]  0-2 位置反转
         * 第三次反转[5,6,7,1,2,3,4]  3-nums.length 位置反转
         */
        // 防止数组越界，而且 k > n ，循环次数就应该等于 k % n ， 如果 k = n , k % n = 0 ; 数组旋转以后位置不变
        k %= nums.length;
        reverse(nums , 0 , nums.length - 1);
        reverse(nums , 0 , k - 1);
        reverse(nums , k , nums.length - 1);
    }

    /**
     * 使用环状替换
     * @param nums
     * @param k
     */
    private static void rotate4(int[] nums, int k) {
//        k = k % nums.length;
        int count = 0;
        for (int start = 0; count < nums.length; start++) {
            int current = start;
            int prev = nums[start];
            do {
                int next = (current + k) % nums.length;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
                count++;
            } while (start != current);
        }
    }


    private static void reverse(int[] nums, int start, int end) {
        int temp;
        while (start < end) {
            temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}

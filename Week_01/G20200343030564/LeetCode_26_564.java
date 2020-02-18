/**
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 *
 * Eg :
 * 给定 nums = [0,0,1,1,1,2,2,3,3,4],
 * 函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
 * 你不需要考虑数组中超出新长度后面的元素。
 *
 */
public class LeetCode_26_564 {

    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        int length = removeDuplicates2(nums);
        System.out.println("过滤后的总长度:" + length);

        for (int i = 0; i < length; i++) {
            System.out.println(nums[i]);
        }
    }

    /**
     * 双指针
     * @param nums
     * @return
     */
    private static int removeDuplicates1(int[] nums) {
        int p = 0;
        int q = 1;
        while (q < nums.length) {
            // 如果 nums[p] = nums[q] , q + 1
            // 如果 nums[p] ≠ nums[q] ，nums[ p + 1 ] = nums[q] ，p + 1 和 q + 1
            // 优化 q > p + 1 才挪
            if (nums[p] != nums[q]) {
                if (q > p + 1) {
                    nums[p + 1] = nums[q];
                }
                p++;
            }
            q++;
        }
        return ++p;
    }

    /**
     * 前插法
     * @param nums
     * @return
     */
    private static int removeDuplicates2(int[] nums) {
        // 如果传入的数据小于等于0就不需要比较了
        // 如果数组大于0；i的初始值设置为1；循环数组的元素，如果元素大于 nums[i-1]，则进行替换，然后i++；最后返回i的值 (从大到小重新排)
        int i = nums.length > 0 ? 1 : 0;
        for (int n : nums) {
            if (n > nums[i-1]) {
                nums[i++] = n;
            }
        }
        return i;
    }
}

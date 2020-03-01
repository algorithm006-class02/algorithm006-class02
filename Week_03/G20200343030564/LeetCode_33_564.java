package week03;

/**
 * 搜索旋转排序数组
 *
 *假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 *
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 *
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 *
 * 你可以假设数组中不存在重复的元素。
 *
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 示例 1:
 *
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 *
 * 示例 2:
 *
 * 输入: nums = [4,5,6,7,0,1,2], target = 3
 * 输出: -1
 *
 */
public class LeetCode_33_564 {

    public static void main(String[] args) {
        LeetCode_33_564 LeetCode = new LeetCode_33_564();
        System.out.println(LeetCode.search(new int[] {4,5,6,7,0,1,2}, 0));
    }

    /**
     * 二分查找
     * 时间复杂度：O(logn)
     * 空间复杂度：O(1)
     *
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (nums[mid] == target) return mid;

            // 前半部有序
            if (nums[low] <= nums[mid]) {
                // target夹在low 和 mid 之间
                if (nums[low] <= target && target < nums[mid]) {
                    high = mid - 1;
                }
                // target在另一边
                else {
                    low = mid + 1;
                }
            }
            // 后半部有序
            else {
                // target夹在mid 和 hight 之间
                if (nums[mid] < target && target <= nums[high]) {
                    low = mid + 1;
                }
                // target在另一边
                else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}

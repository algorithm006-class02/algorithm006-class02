/**
 * @author:
 * @Date: 2020-02-14 18:17
 * @Copyright: 2019 www.lenovo.com Inc. All rights reserved.
 */

//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
//
// 示例:
//
// 输入: [0,1,0,3,12]
//输出: [1,3,12,0,0]
//
// 说明:
//
//
// 必须在原数组上操作，不能拷贝额外的数组。
// 尽量减少操作次数。
//
// Related Topics 数组 双指针
public class LeetCode_283_490 {

    /**
     * two 进行交换 非零与零进行交换，只有当nums[j] != 0的时候 和i!= j的时候交换
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        int i = 0;
        for(int j = 0; j < nums.length ; j++) {
            if(nums[j] != 0) {
                if(i != j) {
                    nums[i] = nums[j];
                    nums[j] = 0;
                }
                i++;
            }
        }
    }

    private void exchange(int[] nums, int i, int j) {
        nums[i] = nums[i] ^ nums[j];
        nums[j] = nums[i] ^ nums[j];
        nums[i] = nums[i] ^ nums[j];
    }

    /*
    //依次遍历将非零的元素按照顺序 存储，接下俩存储为零元素
     public void moveZeroes(int[] nums) {
            int i = 0;
            for(int num : nums) {
                if(num != 0) {
                   nums[i++] = num;
                }
            }
            while(i < nums.length) {
                   nums[i++] = 0;
            }
        }

    */
}

/**
 * 题目：旋转数组
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。

 示例 1:

 输入: [1,2,3,4,5,6,7] 和 k = 3
 输出: [5,6,7,1,2,3,4]
 解释:
 向右旋转 1 步: [7,1,2,3,4,5,6]
 向右旋转 2 步: [6,7,1,2,3,4,5]
 向右旋转 3 步: [5,6,7,1,2,3,4]
 */
class LeetCode_189_022 {
    /**
     1.遍历后k[n-k,n)位 分配到新的数组中，在将[0,n-k)向后移动k位，最后在将新数组的前k位复制回原数组即可
     时间复杂度O(n) 空间复杂度O(k)

     2.暴力：移动k次，每次都移动1个元素记录最后一个元素，移动完后在将最后一个值赋值给0位
     时间复杂度O(n*k) 空间复杂度O(1)

     3.反转法， 先整体反转，在反转0,k-1 在反转k,n-1

     */
    //方法2
    public void rotate(int[] nums, int k) {
        for (int i = 0; i < k; i++) {
            int last = nums[nums.length - 1];
            for (int j = nums.length - 2; j >= 0; j--) {
                nums[j + 1] = nums[j];
            }
            nums[0] = last;
        }
    }




    //方法3
    public void rotate2(int[] nums, int k) {
        k %= nums.length;

        resverse(nums, 0, nums.length - 1);
        resverse(nums, 0, k-1);
        resverse(nums, k, nums.length - 1);
    }

    public void resverse(int[] nums, int start, int end) {
        while(start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
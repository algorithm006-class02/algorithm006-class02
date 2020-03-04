/**
 * 189. 旋转数组
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 */

class Solution {
    // [1,2,3,4,5,6,7] k = 3
    public void rotate(int[] nums, int k) {
        // 边界判定
        k = k % nums.length;

        for (int start = 0, count = 0; count < nums.length; start++) {

            int current = start;
            int prev = nums[start];
            
            do {
                int next = (current + k) % nums.length;
            
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
            
                current = next;
                
                count++;
            } while(start != current);
        }
    }
}
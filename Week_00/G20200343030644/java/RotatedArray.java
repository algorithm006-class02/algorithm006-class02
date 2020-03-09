/** https://leetcode-cn.com/problems/rotate-array/
 *                       reverse - 三次反转
 * 1 2 3 4 5 6 7        -   7 6 5 4 3 2 1
 * ①k=3，移动三位      -   7 6 5\4 3 2 1
 * 5 6 7 1 2 3 4        -   5 6 7\1 2 3 4
 * index = (i + k) % nums.length
 * nums[index] = nums[i]
 */
public class RotatedArray {
    public void rotate(int[] nums, int k) {
        k = k%nums.length;
        //先反转原数组
        reverse(nums,0,nums.length-1);
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);

    }

    public void reverse(int[] nums,int begin,int end){
        while(begin<end){
            int tmp = nums[begin];
            nums[begin++] = nums[end];
            nums[end--] = tmp;
        }
    }
}

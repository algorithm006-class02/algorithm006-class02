/*

假设按照升序排序的数组在预先未知的某个点上进行了旋转。

( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。

请找出其中最小的元素。

你可以假设数组中不存在重复元素。

示例 1:

输入: [3,4,5,1,2]
输出: 1
示例 2:

输入: [4,5,6,7,0,1,2]
输出: 0

 */

package Week_03.G20200343030512;
 class Solution153 {
    public int findMin(int[] nums) {
        int flength = nums.length;
        if (flength ==1) return nums[0];
        return research(nums,0,flength -1);

    }


    private int research(int[] nums,int left,int right){

        if(right ==(left+1))
            return nums[left];


        int mid = (left + right)/2;
        if(nums[mid] > nums[right]){
            return research(nums,mid+1,right);
        }
        else
        {
            return research(nums,left,mid -1);
        }

    }
}
/*

搜索旋转排序数组

假设按照升序排序的数组在预先未知的某个点上进行了旋转。

( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。

搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。

你可以假设数组中不存在重复的元素。

你的算法时间复杂度必须是 O(log n) 级别。


 */
package Week_03.G20200343030512;

class Solution33 {
    public int search(int[] nums, int target) {
        int numslength = nums.length;
        if (numslength == 0) return -1;
        return searchbinary(nums, 0,numslength -1,target);
    }

    private int searchbinary(int[] nums, int low,int high, int target){
        if(low > high) return -1;
        int mid = (low + high)/2;
        if(nums[mid]== target ) return mid;

        if(nums[mid]< nums[high]){
            if(nums[mid] < target && target <= nums[high])
                return searchbinary(nums, mid +1,high,target);
            else
                return searchbinary(nums, low,mid -1,target);
        }
        else{
            if(nums[low] <= target && target < nums[mid])
                return searchbinary(nums, low,mid -1,target);
            else
                return searchbinary(nums, mid +1,high,target);
        }

    }


}
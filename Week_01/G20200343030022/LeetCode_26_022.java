/**
 * 题目：删除排序数组中重复的元素
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 */
class LeetCode_26_022 {

    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int slow = 0;
        int fast = 0;
        while(fast != nums.length){
            if(nums[slow] != nums[fast]){
                nums[++slow] = nums[fast];
            }
            fast++;
        }
        return slow+1;
    }

}
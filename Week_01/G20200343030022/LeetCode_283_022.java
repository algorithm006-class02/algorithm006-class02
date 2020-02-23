
/**
 * 题目：移动零
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 */
public class LeetCode_283_022{

    public void moveZeroes(int[] nums) {
        int slow = 0;
        int fast = 0;
        while(fast < nums.length){
            if(nums[fast] == 0){
                fast++;
            }else{
                swap(nums, slow++, fast++);
            }

        }

    }

    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

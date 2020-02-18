/**
 *  Week 01  LeetCode 283
 * 
 *  283.移动零
 */

public void moveZeroes(int[] nums) {
    int index =0;
    for(int i =0;i<nums.length;i++){
        if(nums[i]!=0){
            nums[index]=nums[i];
            if(i!=index){
                nums[i]=0;
            }
            index++;
        }
    }
}

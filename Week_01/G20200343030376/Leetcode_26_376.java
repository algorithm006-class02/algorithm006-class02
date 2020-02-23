/**
 *  Week 01  LeetCode 26
 * 
 *  26.删除数组中的重复项
 */
public int removeDuplicates(int[] nums) {
    int index=0;
    for(int i =1;i<nums.length;i++){
        if(nums[index]!=nums[i]){
            nums[index+1]=nums[i];
            index++;
        }
        
    }
    return index;
}



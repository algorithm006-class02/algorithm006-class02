/**
 *  Week 01  LeetCode 189
 * 
 *  189.旋转数组
 */
public void rotate(int[] nums, int k) {
        
    int temp;
    int lastNumber;
    for(int i =0; i<k;i++){
        lastNumber=nums[nums.length-1];
        for(int j=0;j<nums.length;j++){
            temp=nums[j];
            nums[j]=lastNumber;
            lastNumber=temp;
        }
    }

}
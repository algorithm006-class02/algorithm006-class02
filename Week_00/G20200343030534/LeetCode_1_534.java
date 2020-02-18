package com.test.datastructure;

public class RemoveRepeat {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int []nums = {0,0,1,1,1,2,2,3,3,4};
        int result = removeDuplicates(nums);
        System.out.println(result);
        
        int []nums2 = {1,2,3};
        int result2 = removeDuplicates(nums2);
        System.out.println(result2);

        int []nums3 = {1,1};
        int result3 = removeDuplicates(nums3);
        System.out.println(result3);
        
        int []nums4 = {1,1, 1};
        int result4 = removeDuplicates(nums4);
        System.out.println(result4);

        int []nums5 = {1};
        int result5 = removeDuplicates(nums5);
        System.out.println(result5);
        
        int []nums6 = {};
        int result6 = removeDuplicates(nums6);
        System.out.println(result6);


    }
    
    public static int removeDuplicates(int[] nums) {
        int resultIndex = 0;
        if(nums == null) {
            return resultIndex;
        }
        if(nums.length == 0) {
            return resultIndex;
        }
        
        for(int i = 0, j = 1; i <= j; ) {
            
            if(i >= nums.length - 1) {
                break;
            }
            
            int target = nums[i];
            while(j < nums.length) {
                if(target == nums[j]) {
                    if(j + 1 == nums.length) {
                        j ++;
                        i = j;
                    } else {
                        j ++;
                    }
                } else {
                    
                    resultIndex++;
                    nums[resultIndex] = nums[j]; 
                    i = j;
                    ++j;
                    break;
                }
            }

        }
        return resultIndex + 1;
    }

}

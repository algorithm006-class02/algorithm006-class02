package com.test.datastructure;

import java.util.Arrays;

public class LongestIncreasingSubsquence300 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        LongestIncreasingSubsquence300 a = new LongestIncreasingSubsquence300();
        int [] input = {4,10,4,3,8,9};
        System.out.println(a.lengthOfLIS(input));
    }

    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        if(nums.length == 1) return 1;
        int[] result = new int[nums.length];
        result[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            int temp = 0;
            for(int j = i - 1; j >=0; j--) {
                if(nums[i] > nums[j]) {
                    temp = result[j] > temp?  result[j]: temp;
                }
            }
            result[i] = temp + 1;
        }
        System.out.println(Arrays.toString(result));
        return Arrays.stream(result).max().getAsInt();
    }
}

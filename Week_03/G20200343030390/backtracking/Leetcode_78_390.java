package com.subject.week03.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 *78.子集
 *
 *
 * 思路（精简）：
 * 1.回溯法 递归
 *
 * 2.迭代
 *
 *
 */
public class Leetcode_78_390 {
    /**
     * 1.递归
     * @param nums
     * @return
     */
    public  List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        if(nums.length == 0){
            return list;
        }
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, 0);
        return list;
    }

    private  void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int start){
        list.add(new ArrayList<>(tempList));
        for(int i = start; i < nums.length; i++){
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }

    /**
     * 2.迭代
     * @param nums
     * @return
     */
    public List<List<Integer>> subsetsTwo(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        if(nums.length == 0){
            return result;
        }
        Arrays.sort(nums);




        return result;
    }
}
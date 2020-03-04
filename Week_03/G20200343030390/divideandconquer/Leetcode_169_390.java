package com.subject.week03.divideandconquer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *
 *
 * 169.多数元素
 *
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 * 示例 1:
 *
 * 输入: [3,2,3]
 * 输出: 3
 * 示例 2:
 *
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 *
 * 思路（精简）：
 *
 * 1.分治
 *
 * 2.哈希表
 *  时间复杂度O(n)
 *  空间复杂度O(n)
 *
 * 3.排序
 *  时间复杂度O(logn)
 *
 *
 */
public class Leetcode_169_390 {
    public int majorityElement(int[] nums) {
        // 2.哈希表
        int result = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int num : nums) {
            if(!map.containsKey(num)) {
                map.put(num,1);
            } else {
                map.put(num,map.get(num)+1);
            }
            if(map.get(num) > (nums.length /2)) {
                result = num;
                break;
            }
        }
        return result;


        // 3.排序
//        Arrays.sort(nums);
//        return nums[nums.length/2];
    }
}
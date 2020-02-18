package com.leetcode.base;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    /**
     * 题一：删除排序数组中的重复项
     * 快慢指针方式：前提条件数组或者链表有序，慢指针作为一个边界，快指针作为另一个边界，移动数据到慢指针边界(替换操作)
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int index = 0;
        for(int i = 1;i < nums.length ; ++i){
            if(nums[i] != nums[index]){
                nums[++index] = nums[i];
            }
        }
        return index + 1;
    }

    /**
     * 题二：旋转数组
     * 通过反转3次数组达到目的（很巧妙）
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        if(nums == null || nums.length == 0 || k == 0){
            return;
        }
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end){
        while(start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    /**
     * 题三：合并两个有序链表
     * 方法一：递归
     * 思路：排序好的链表头与val值比较小的相接，直到l1或者l2为空递归结束
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists_1(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }else if(l1.val < l2.val){
            l1.next = mergeTwoLists_1(l1.next, l2);
            return l1;
        }else{
            l2.next = mergeTwoLists_1(l1, l2.next);
            return l2;
        }
    }

    /**
     * 题三：合并两个有序链表
     * 方法一：迭代
     * 注意点：新建一个链表，需要辅助结点cur来完成链表结点的相接，不能直接返回cur.next,
     * 因为cur已指向链表最后。操作链表时常常需要一个辅助结点来完成遍历、插入、删除等操作。
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists_2(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        while (l1 != null && l2 != null) {
            if(l1.val < l2.val){
                cur.next = l1;
                l1 = l1.next;
            }else{
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = l1 == null ? l2 : l1;
        return head.next;
    }

    /**
     * 题四：合并两个有序数组
     * 思路：双指针方法，指针从前往后或者从后往前。根据本题情景，nums1后面元素需要填充，直接选用从后往前比较的方式更好。
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        int p = m + n - 1;
        while(p1 >= 0 && p2 >= 0){
            nums1[p--] = nums1[p1] < nums2[p2] ? nums2[p2--] : nums1[p1--];
        }
        System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
    }

    /**
     * 题五：两数之和
     * 思路：通过空间换时间升维的方式，将暴力双层循环拆解为遍历单遍哈希表的方式解决，时间复杂度由O(n^2)降为O(n)。
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            int result = target - nums[i];
            if (map.containsKey(result)) {
                return new int[]{map.get(result), i};
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    /**
     * 题六：移动零
     * 思路：与题一相似，通过快慢指针解决(交换)
     * @param nums
     */
    //1,0,1,0,1,2
    //第一遍：index=0,i=0  1,0,1,0,1,2   index++
    //第二遍：index=1,i=2  1,1,0,0,1,2   index++
    //第三遍：index=2,i=4  1,1,1,0,0,2   index++
    //第四遍：index=3,i=5  1,1,1,2,0,0
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int index = 0;//慢指针
        for (int i = 0; i < nums.length; i++) { //i快指针
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[index];
                nums[index++] = temp;
            }
        }
    }

    /**
     * 题七：加一
     * 思路：数组倒序遍历，（数组元素+1）% 10 != 0 结束，否则继续遍历，特殊情况99这种，数组扩容1位。
     * @param digits
     * @return
     */
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        for (int i = len -1; i >= 0; i++) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) {
                return digits;
            }
        }
        digits = new int[len + 1];
        digits[0] = 1;
        return digits;
    }
}

class ListNode{
    int val;
    ListNode next;
    ListNode(int x){
        val = x;
    }
}

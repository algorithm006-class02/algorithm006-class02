package com.example.leetCode.week1;

public class LeetCode_189_386 {

    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        int count = 0;
        for (int start = 0; count < nums.length; start++) {
            int current = start;
            int currentNum = nums[start];
            do {
                int next = (current + k) % nums.length;
                int nextNum = nums[next];
                nums[next] = currentNum;
                current = next;
                currentNum = nextNum;
                count++;
            } while (current != start);
        }
    }

}

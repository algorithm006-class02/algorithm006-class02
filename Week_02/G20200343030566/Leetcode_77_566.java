package com.sebar.test.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author liguang
 * @Date 2020/2/22
 * @Description
 */
public class Leetcode_77_566 {
    /**
     * 暴力求解，循环查找所有组合
     *
     * @param n
     * @param k
     * @return
     */
    List<List<Integer>> resList = new ArrayList<>();
    int n;
    int k;

    public List<List<Integer>> combine(int n, int k) {
        this.n = n;
        this.k = k;
        backTrack(1, new LinkedList<>());

        return resList;
    }

    private void backTrack(int i, LinkedList<Integer> currentList) {
        // 等于阀值的时候，将当前列表添加到结果集
        if (currentList.size() == k) {
            resList.add(new LinkedList<>(currentList));
            return;
        }

        for (int j = i; j <= n; j++) {
            currentList.add(j);
            // 重新添加循环
            backTrack(j + 1, currentList);
            // 移除最后一个元素，继续循环
            currentList.removeLast();
        }
    }

    public static void main(String[] args) {
        Leetcode_77_566 code = new Leetcode_77_566();
        List<List<Integer>> combine = code.combine(4, 3);
        System.out.println(combine);
    }
}

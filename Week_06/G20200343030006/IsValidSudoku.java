package com.leetcode.base.week06;

import java.util.HashMap;

public class IsValidSudoku {
    //思路：
    //1.枚举子数独：box_index = (row / 3) * 3 + columns / 3
    //2.value->count哈希映射来跟踪所有已经遇到的值
    //Map：merge()它将新值置于指定的key键下（如果不存在）或更新具有给定值的现有键（upset）。
    //Map.merge()意味着我们够可以原子地执行插入或更新操作，它是线程安全的。
    //ConcurrentHashMap虽然也是线程安全的，但不是所有操作都是。例如：get()之后再put()就不是了
    //这时使用merge()保证没有更新会丢失。
    public boolean isValidSudoku(char[][] board) {
        HashMap<Integer, Integer>[] rows = new HashMap[9];
        HashMap<Integer, Integer>[] columns = new HashMap[9];
        HashMap<Integer, Integer>[] boxes = new HashMap[9];
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashMap<>();
            columns[i] = new HashMap<>();
            boxes[i] = new HashMap<>();
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int key = board[i][j];
                    int boxIdx = (i / 3) * 3 + j / 3;
                    if (rows[i].merge(key, 1, (a, b) -> a + b) > 1) {
                        return false;
                    }
                    if (columns[j].merge(key, 1, (a, b) -> a + b) > 1) {
                        return false;
                    }
                    if (boxes[boxIdx].merge(key, 1, (a, b) -> a + b) > 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}

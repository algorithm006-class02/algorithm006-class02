package com.leetcode.base.week06;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    //回溯法
    //模板：
    //1.终止条件
    //2.处理当前层
    //3.下探到下一层
    //4.清理变量
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList();
        backtrack(ans, "", 0, 0, n);
        return ans;
    }

    public void backtrack(List<String> ans, String cur, int open, int close, int max){
        if (cur.length() == max * 2) {
            ans.add(cur);
            return;
        }
        if (open < max) {
            backtrack(ans, cur + "(", open + 1, close, max);
        }
        if (close < open) {
            backtrack(ans, cur + ")", open, close + 1, max);
        }
    }
}

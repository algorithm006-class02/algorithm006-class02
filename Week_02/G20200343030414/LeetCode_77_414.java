package Week_02.G20200343030414;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Xinshuai
 * @description 题目链接：https://leetcode-cn.com/problems/combinations/
 * @since 2020-02-23 19:13
 */
public class LeetCode_77_414 {

    /**
     * 1、通过递归解决
     */
    public List<List<Integer>> combine(int n, int k) {
        if (k > n) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        addToList(res, new ArrayList<>(), n, k, 1);
        return res;
    }

    private void addToList(List<List<Integer>> res, ArrayList<Integer> currList, int n, int k, int m) {
        if (k == 0) { // 终止条件
            res.add(new ArrayList<>(currList));
            return;
        }
        for (int i = m; i < n - k + 1; i ++) {
            currList.add(i); // 处理当前层逻辑
            addToList(res, currList, n, k - 1, i + 1); // 进入下一层
            currList.remove(currList.size() - 1);
        }
    }
}

/*
 * @lc app=leetcode.cn id=77 lang=java
 *
 * [77] 组合
 */

// @lc code=start
class Solution {
    //    回溯 + 剪枝
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        getAns(1, n, k, new ArrayList<Integer>(), ans);
        return ans;
    }

    private void getAns(int start, int n, int k, ArrayList<Integer> temp, List<List<Integer>> ans) {
        if (temp.size() == k) {
            ans.add(new ArrayList<Integer>(temp));
            return;
        }
        // 这里代表我们还需要的数字 个数 这样就是起到剪枝的作用 把没用不够数的步骤循环遍历去掉
        //优化了时间
        for (int i = start; i <= n - (k - temp.size()) + 1; i++) {
            temp.add(i);
            getAns(i + 1, n, k, temp, ans);
            temp.remove(temp.size() - 1);
        }
    }
}
// @lc code=end


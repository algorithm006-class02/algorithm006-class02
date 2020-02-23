/*
 * @lc app=leetcode.cn id=77 lang=java
 *
 * [77] 组合
 */

// @lc code=start
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(1,n,k,new ArrayList(),res);
        return res;
    }
    public void backtrack(int start, int n, int k, List<Integer> tmp, List<List<Integer>> list){
        if(tmp.size() == k){
            list.add(new ArrayList<>(tmp));
            return;
        }
        for(int i = start; i <= n - (k - tmp.size()) + 1; i++){
            tmp.add(i);
            backtrack(i+1, n , k, tmp ,list);
            tmp.remove(tmp.size() - 1);
        }
    }
}
// @lc code=end


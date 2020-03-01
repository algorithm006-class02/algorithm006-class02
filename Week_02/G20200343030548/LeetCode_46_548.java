/*
 * @lc app=leetcode.cn id=46 lang=java
 *
 * [46] 全排列
 */

// @lc code=start
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        int[] visited = new int[nums.length];
        backtrack(res,visited,nums,new ArrayList<>());
        return res;
    }
    public void backtrack(List<List<Integer>> res,int[] visited,int[] nums, List<Integer> tmp){
        if(tmp.size() == nums.length){
            res.add(new ArrayList<>(tmp));
            return;
        }
        for(int i = 0; i < nums.length;i++){
            if(visited[i] == 1) continue;
            visited[i] = 1;
            tmp.add(nums[i]);
            backtrack(res,visited,nums,tmp);
            visited[i] = 0;
            tmp.remove(tmp.size() - 1);
        }
    }
}
// @lc code=end


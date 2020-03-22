import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=51 lang=java
 *
 * [51] N皇后
 */

// @lc code=start
class Solution {
    private Set<Integer> col = new HashSet<Integer>();
    private Set<Integer> pie = new HashSet<Integer>();
    private Set<Integer> na = new HashSet<Integer>();

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<List<String>>();
        dfs(res, new ArrayList<String>(), 0, n);
        return res;
    }

    private void dfs(List<List<String>> res, List<String> list, int row, int n) {
        if(row == n) {
            res.add(new ArrayList<String>(list));
            return;
        }
        for(int i = 0; i < n; i++) {
            if(col.contains(i) || pie.contains(row + i) || na.contains(row - i)){
                continue;
            }
            char[] charArray = new char[n];
            Arrays.fill(charArray,'.');
            charArray[i] = 'Q';
            String rowString = new String(charArray);
            list.add(rowString);
            col.add(i);
            pie.add(row + i);
            na.add(row - i);
            dfs(res, list, row + 1, n);
            list.remove(list.size() - 1);
            col.remove(i);
            pie.remove(row + i);
            na.remove(row - i);
        }
    }
}
// @lc code=end


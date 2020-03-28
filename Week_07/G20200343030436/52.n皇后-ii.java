import java.util.ArrayDeque;

/*
 * @lc app=leetcode.cn id=52 lang=java
 *
 * [52] N皇后 II
 */

// @lc code=start
class Solution {
    private Set<Integer> col = new HashSet<Integer>();
    private Set<Integer> pie = new HashSet<Integer>();
    private Set<Integer> na = new HashSet<Integer>();

    public int totalNQueens1(int n) {
        List<List<String>> res = new ArrayList<List<String>>();
        dfs(res, new ArrayList<String>(), 0, n);
        return res.size();
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
    /**
     * 位运算的效率最好的
     * 
     * 
     * 
     * 用一个int的二进制来表示col pie na
     * dfs n
     * row 表示我们当前在哪一层
     * 一个int的二进制来表示col pie na 其实和set异曲同工
     * 取反就是没有打掉的格子就赋为1  取到最低位的1 是1就是可以放进去
     */

     private int size;
     private int count;

     private void solve(int row, int ld, int rd) {
         if (row == size) {
             count++;
             return;
         }
         int pos = size & (~(row | ld | rd));//得到当前所有的空位
         while (pos != 0) {//当前空位不为0的时候
             int p = pos & (-pos);//取到最低位的1
             pos -= p;
             solve(row | p, (ld | p) << 1, (rd | p) >> 1);// 得到这个空位之后 把他给相应的列 撇 捺里面去更新以 继续下一层的更新
         }
     }

     public int totalNQueens(int n) {
         count = 0;
         size = (1 << n) - 1;//size 表示可以填皇后的位置 把1挪了n位再减1
         solve(0, 0, 0);
         return count;
     }
}
// @lc code=end


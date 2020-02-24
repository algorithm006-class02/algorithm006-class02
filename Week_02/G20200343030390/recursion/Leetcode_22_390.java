/**
 *
 *  22.括号生成
 *给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 *
 * 例如，给出 n = 3，生成结果为：
 *
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 *
 *
 * 思路（精简）：
 * 1.暴力法 生成后比较是否有效
 *
 * 2.回溯法
 *
 */
public class Leetcode_22_390 {
    /**
     * 回溯法
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        backtrack(list,"",0,0,n);
        return list;
    }

    private void backtrack(List<String> list,String str, int open , int close, int n) {
        if(str.length() == 2 * n){
            list.add(str);
            return;
        }
        if(open < n) {
            backtrack(list,str +"(",open+1,close,n);
        }
        if(close < open) {
            backtrack(list,str +")", open,close+1,n);
        }
    }
}

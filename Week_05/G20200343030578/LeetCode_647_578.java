//给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
//
// 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被计为是不同的子串。
//
// 示例 1:
//
//
//输入: "abc"
//输出: 3
//解释: 三个回文子串: "a", "b", "c".
//
//
// 示例 2:
//
//
//输入: "aaa"
//输出: 6
//说明: 6个回文子串: "a", "a", "a", "aa", "aa", "aaa".
//
//
// 注意:
//
//
// 输入的字符串长度不会超过1000。
//
// Related Topics 字符串 动态规划


class Solution647 {
    // 参考题解
    // 链接：https://leetcode-cn.com/problems/palindromic-substrings/solution/dong-tai-gui-hua-shi-xian-hui-wen-zi-chuan-de-tong/
    // 状态数组： dp[i][j] ，表示第 i 个位置开始到第 j 个位置字串是否是回文串
    // 转移方程
        // 如果 start == end,肯定是回文子串
        // 如果 end > start,那么这个字符串是不是回文串取决于
        // 字符串头和尾巴是否相等并且去除头尾剩余的字符串是不是对应的回文串
    public int countSubstrings(String s) {
        if(s == null){
            return 0;
        }
        if(s.length() == 0 || s.length() == 1){
            return s.length();
        }
        int n = s.length();
        int result = 0;
        boolean[][] dp = new boolean[n][n];
        for(int end = 0; end < n; end++){
            for(int start = 0; start <= end; start++){
                if(start == end){
                    dp[start][end] = true;
                    result++;
                }else{
                    if(s.charAt(start) == s.charAt(end) && (end-start <= 1 || dp[start+1][end-1])){
                        dp[start][end] = true;
                        result++;
                    }
                }
            }
        }
        return result;
    }
}

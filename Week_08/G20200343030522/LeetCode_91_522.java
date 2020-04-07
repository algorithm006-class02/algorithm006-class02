//一条包含字母 A-Z 的消息通过以下方式进行了编码： 
//
// 'A' -> 1
//'B' -> 2
//...
//'Z' -> 26
// 
//
// 给定一个只包含数字的非空字符串，请计算解码方法的总数。 
//
// 示例 1: 
//
// 输入: "12"
//输出: 2
//解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
// 
//
// 示例 2: 
//
// 输入: "226"
//输出: 3
//解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
// 
// Related Topics 字符串 动态规划


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numDecodings(String s) {
        if (s.startsWith("0")) {
            return 0;
        }
        char[] nums = s.toCharArray();
        int[] dp = new int[nums.length+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == '0') {
                if (nums[i - 1] != '1' && nums[i - 1] != '2') {
                    return 0;
                }
                dp[i+1] = dp[i - 1];
            } else if (nums[i - 1] == '1' || (nums[i - 1] == '2' && nums[i] <= '6')) {
                dp[i+1] = dp[i - 1] + dp[i];
            } else {
                dp[i+1] = dp[i];
            }

        }
        return dp[nums.length];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

package week08;

/**
 * 解密方法
 *
 *一条包含字母 A-Z 的消息通过以下方式进行了编码：
 *
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 给定一个只包含数字的非空字符串，请计算解码方法的总数。
 *
 * 示例 1:
 *
 * 输入: "12"
 * 输出: 2
 * 解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
 *
 * 示例 2:
 *
 * 输入: "226"
 * 输出: 3
 * 解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
 *
 */
public class LeetCode_91_564 {

    public static void main(String[] args) {
        LeetCode_91_564 leetCode = new LeetCode_91_564();
        System.out.println(leetCode.numDecodings("12"));
        System.out.println(leetCode.numDecodings1("12"));
    }

    /**
     * 动态规划
     * 时间复杂度：O(m) 字符串的长度
     * 空间复杂度：O(m) 字符串的长度
     *
     * @param s
     * @return
     */
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) return 0;
        int len = s.length();
        int[] dp = new int[len + 1];

        dp[len] = 1;

        if (s.charAt(len - 1) != '0') dp[len - 1] = 1;
        else dp[len - 1] = 0;

        for (int i = len - 2; i >= 0; i--) {
            // 1.如果为0 ，则dp[i] = 0;
            // 2.如果上一个和本个数值相加小于26，dp[i] = dp[i + 1] + dp[i + 2];
            // 3.如果上一个和本个数值相加大于26, dp[i] = dp[i + 1];
            if (s.charAt(i) == '0') {
                dp[i] = 0;
            }else if ((s.charAt(i) - '0') * 10 + (s.charAt(i + 1) - '0') <= 26) {
                dp[i] = dp[i + 1] + dp[i + 2];
            }else {
                dp[i] = dp[i + 1];
            }

        }
        return dp[0];
    }

    /**
     * 动态规划  简化版
     * 时间复杂度：O(m) 字符串的长度
     * 空间复杂度：O(1)
     * @param s
     * @return
     */
    public int numDecodings1(String s) {
        if (s == null || s.length() == 0) return 0;
        int len = s.length();

        int temp = 1;
        int res;
        if (s.charAt(len - 1) != '0') res = 1;
        else res = 0;

        for (int i = len - 2; i >= 0; i--) {
            // temp 存 res 前面的值
            if (s.charAt(i) == '0') {
                temp = res;
                res = 0;
            }else if ((s.charAt(i) - '0') * 10 + (s.charAt(i + 1) - '0') <= 26) {
                res += temp;
                temp = res - temp;
            }else {
                temp = res;
            }

        }
        return res;
    }

}

package week08;


/**
 * 字符串转换整数 (atoi)
 *
 * 示例 1:
 *
 * 输入: "42"
 * 输出: 42
 * 示例 2:
 *
 * 输入: "   -42"
 * 输出: -42
 * 解释: 第一个非空白字符为 '-', 它是一个负号。
 *      我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42 。
 *
 *
 * 示例 3:
 *
 * 输入: "4193 with words"
 * 输出: 4193
 * 解释: 转换截止于数字 '3' ，因为它的下一个字符不为数字。
 *
 *
 * 示例 4:
 *
 * 输入: "words and 987"
 * 输出: 0
 * 解释: 第一个非空字符是 'w', 但它不是数字或正、负号。
 *      因此无法执行有效的转换。
 *
 *
 * 示例 5:
 *
 * 输入: "-91283472332"
 * 输出: -2147483648
 * 解释: 数字 "-91283472332" 超过 32 位有符号整数范围。
 *      因此返回 INT_MIN (−231) 。
 *
 */
public class LeetCode_8_564 {

    public static void main(String[] args) {
        LeetCode_8_564 leetCode = new LeetCode_8_564();
        System.out.println(leetCode.myAtoi("words and 987"));
    }

    /**
     *
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     *
     * @param str
     * @return
     */
    public int myAtoi(String str) {
        // 1.去除前面的空格
        // 2.判断正负号
        // 3.循环判断是否是数字切不越界，如果越界，负数就返回Integer的最小值，整数就返回最大值
        if (str == null || str.length() == 0) return 0;
        int len = str.length();
        char[] chars = str.toCharArray();
        int idx = 0;
        while (idx < len && chars[idx] == ' ') idx++;

        if (idx == len) return 0;

        // 默认是正数
        boolean negative = false;
        if (chars[idx] == '-') {
            negative = true;
            idx++;
        }else if (chars[idx] == '+'){
            idx++;
        }else if (!Character.isDigit(chars[idx])) {
            return 0;
        }

        int res = 0;
        while (idx < len && Character.isDefined(chars[idx])) {
            int digit = chars[idx] - '0';
            if (res > (Integer.MAX_VALUE - digit) / 10) {
               return negative ? Integer.MIN_VALUE : Integer.MIN_VALUE;
            }
            res = chars[idx] * 10 + digit;
            idx++;
        }

        return negative ? -res : res;
    }
}

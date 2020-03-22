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


class Solution91 {
    // 子问题
    // 状态数组 a[n]
    // 转移方程
    // 类似爬楼梯，但要注意范围，而且对 0 要特殊处理
    public int numDecodings(String s) {
        int n = s.length();
        // 特殊情况
        if (n == 0)
            return 0;
        else if (n == 1) {
            if (isBetween(s.substring(0, 1))) {
                return 1;
            } else {
                return 0;
            }
        }
        // 状态数组定义
        int[] a = new int[n];
        // 初始化
        if (isBetween(s.substring(0, 1))) {
            a[0] = 1;
        } else {
            a[0] = 0;
        }
        if (!isBetween(s.substring(1, 2))) {
            a[0] = 0;
        }
        if (isBetween(s.substring(0, 2)))
            a[1] = a[0] == 1 ? 2 : 1;
        else
            a[1] = a[0] == 1 ? 1 : 0;
        // 递推
        for (int i = 2; i < n; i++) {
            if (isBetween(s.substring(i - 1, i + 1))) {
                if (isBetween(s.substring(i, i + 1))) {
                    a[i] = a[i - 1] + a[i - 2];
                } else {
                    a[i] = a[i - 2];
                }
            } else {
                if (isBetween(s.substring(i, i + 1))) {
                    a[i] = a[i - 1];
                } else {
                    a[i] = 0;
                }
            }

        }
        // 返回结果
        return a[n - 1];
    }

    private boolean isBetween(String substring) {
        int num;

        if (substring.length() == 1) {
            num = Integer.parseInt(substring);
            if (num >= 1 && num <= 9)
                return true;
            else// 含 "0" 的情况
                return false;
        } else {
            num = Integer.parseInt(substring);
            if (num >= 10 && num <= 26)
                return true;
            else// 其他越界的情况
                return false;
        }
    }
}

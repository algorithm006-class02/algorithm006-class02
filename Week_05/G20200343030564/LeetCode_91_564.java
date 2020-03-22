package week05;

import java.util.HashMap;

/**
 * 解码方法
 * 一条包含字母 A-Z 的消息通过以下方式进行了编码：
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
 * 示例 2:
 *
 * 输入: "226"
 * 输出: 3
 * 解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
 *
 *
 */
public class LeetCode_91_564 {

    public static void main(String[] args) {
        LeetCode_91_564 leetCode = new LeetCode_91_564();
        System.out.println(leetCode.numDecodings("232232323232"));
        System.out.println(leetCode.numDecodings1("232232323232"));
        System.out.println(leetCode.numDecodings2("232232323232"));
    }

    /**
     * 递归方式
     * 时间复杂度：
     * 空间复杂度：
     *
     * 思路：232232323232 可以分解为 2|32232323232 和 23|2232323232
     * 计算 32232323232 + 2232323232解码方式就可以得出 232232323232的解码方式
     *
     * 运用缓存的方式
     * @param s
     * @return
     */
    public int numDecodings(String s) {
        if (s.length() == 0) return 0;

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        return dfs(s, 0, map);
    }

    private int dfs(String s, int level, HashMap<Integer, Integer> map) {
        // terminator 到了最后一个字母，默认有一种编译方式
        if (level == s.length()) return 1;

        // process current logic
        if (s.charAt(level) == '0') {
            return 0;
        }
        if (map.get(level) != null) return map.get(level);

        // 第一种分解
        int ans1 = dfs(s, level + 1, map);

        // 第二种组合分解
        int ans2 = 0;
        if (level < s.length() - 1) {
            int ten = (s.charAt(level) - '0') * 10;
            int one = s.charAt(level + 1) - '0';
            if (ten + one <= 26) ans2 = dfs(s, level + 2, map);
        }
        map.put(level, ans1 + ans2);
        return ans1 + ans2;
    }

    /**
     * 动态规划
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     *
     * @param s
     * @return
     */
    public int numDecodings1(String s) {
        int length = s.length();
        if (length == 0) return 0;

        int[] dp = new int[length + 1];
        // 定义dp数组，记录的是后往前迭代的时候最后两个数的组合解码情况
        dp[length] = 1;

        // 如果最后一个如果不为0，则置换为1
        if (s.charAt(length - 1) != '0') dp[length - 1] = 1;

        for (int i = length - 2; i >= 0; i--) {
            if (s.charAt(i) == '0') continue;
            int ans1 = dp[i + 1];
            int ans2 = 0;
            int ten = (s.charAt(i + 1) - '0') * 10;
            int one = s.charAt(i) - '0';
            if (ten + one <= 26) ans2 = dp[i + 2];
            dp[i] = ans1 + ans2;
        }
        return dp[0];
    }


    /**
     * 动态规划 优化
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     *
     * 因为只保留 dp[i + 1] 和 dp [i + 2] 的信息，所以可以用两个变量来存
     *
     * @param s
     * @return
     */
    public int numDecodings2(String s) {
        int length = s.length();
        if (length == 0) return 0;
        int end = 1;
        int cur = 0;
        if (s.charAt(length - 1) != '0') cur = 1;

        for (int i = length - 2; i >= 0 ; i--) {
            // 然后当前是0，则把cur当前值置为0
            if (s.charAt(i) == '0') {
                cur = 0;
                continue;
            }
            int ans1 = cur;
            int ans2 = 0;
            int ten = (s.charAt(i + 1) - '0') * 10;
            int one = s.charAt(i) - '0';
            if (ten + one <= 26) ans2 = end;
            end = cur;
            cur = ans1 + ans2;
        }
        return cur;
    }
}

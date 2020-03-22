package week5;

import java.util.HashMap;
import java.util.Map;

/**
 * 91. 解码方法
 * 一条包含字母 A-Z 的消息通过以下方式进行了编码：
 * <p>
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 给定一个只包含数字的非空字符串，请计算解码方法的总数。
 * <p>
 * 示例 1:
 * 输入: "226"
 * 输出: 3
 * 解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
 * <p>
 * https://leetcode-cn.com/problems/decode-ways/
 */
public class DecodeWays {
    public static void test() {
        String target = "232232323232";
        System.out.println("解码方法数：" + new DecodeWays().numDecodings4(target));
    }

    public int numDecodings(String s) {
        // 递归
        // https://leetcode-cn.com/problems/decode-ways/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-2-3/
        return dpHelper(s, 0);
    }

    private int dpHelper(String content, int index) {
        // terminator
        if (content.length() == index) return 1;
        if (content.charAt(index) == '0') return 0;

        // process current logic
        // drill down

        // dp方程由来分析：例：232232323232
        // 因为字母的最大值是26，所以如果两个数组合大于26，则这两个数肯定不能由一个字母表示，必须从中间切开，即前一个数字肯定就只能是一个字母；
        // 否则，至少有2种切法：在中间切一刀，在第二个字母后面切一切；以此类推。
        int part1 = dpHelper(content, index + 1);
        int part2 = 0;
        if (index < content.length() - 1) {
            int ten = content.charAt(index) - '0';
            int one = content.charAt(index + 1) - '0';
            if (ten * 10 + one <= 26) {
                part2 = dpHelper(content, index + 2);
            }
        }

        // restore current state
        return part1 + part2;
    }

    public int numDecodings2(String s) {
        // 递归 - 加缓存
        Map<Integer, Integer> cache = new HashMap<>();
        return dpHelper2(s, 0, cache);
    }

    private int dpHelper2(String content, int index, Map<Integer, Integer> cache) {
        // terminator
        if (content.length() == index) return 1;
        if (content.charAt(index) == '0') return 0;

        if (cache.containsKey(index)) {
            return cache.get(index);
        }
        int part1 = dpHelper2(content, index + 1, cache);
        int part2 = 0;
        if (index < content.length() - 1) {
            int ten = content.charAt(index) - '0';
            int one = content.charAt(index + 1) - '0';
            if (ten * 10 + one <= 26) {
                part2 = dpHelper2(content, index + 2, cache);
            }
        }
        cache.put(index, part1 + part2);
        // restore current state
        return part1 + part2;
    }

    public int numDecodings3(String s) {
        // 动态规划 - 一维dp数组，由后往前
        if (s.charAt(0) == '0') return 0;
        int length = s.length();
        int[] dp = new int[length + 1];
        dp[length] = 1;
        if (s.charAt(length - 1) != '0')
            dp[length - 1] = 1;

        for (int i = length - 2; i >= 0; i--) {
            if (s.charAt(i) == '0')
                continue;

            int part1 = dp[i + 1];
            int part2 = 0;
            int ten = s.charAt(i) - '0';
            int one = s.charAt(i + 1) - '0';
            if (ten * 10 + one <= 26) {
                part2 = dp[i + 2];
            }
            dp[i] = part1 + part2;
        }
        return dp[0];
    }

    public int numDecodings4(String s) {
        // 动态规划 - 只记忆2个数
        if (s.charAt(0) == '0') return 0;
        int length = s.length();
        int curr = 0;
        int end = 1;
        if (s.charAt(length - 1) != '0')
            curr = 1;

        for (int i = length - 2; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                end = curr;
                curr = 0;
                continue;
            }
            int value = 0;
            int ten = s.charAt(i) - '0';
            int one = s.charAt(i + 1) - '0';
            if (ten * 10 + one <= 26) {
                value = end;
            }
            end = curr;
            curr += value;
        }
        return curr;
    }
}

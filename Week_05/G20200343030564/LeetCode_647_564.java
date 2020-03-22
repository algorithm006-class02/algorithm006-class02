package week05;

/**
 * 回文子串
 * <p>
 * 定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
 * <p>
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被计为是不同的子串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abc"
 * 输出: 3
 * 解释: 三个回文子串: "a", "b", "c".
 * 示例 2:
 * <p>
 * 输入: "aaa"
 * 输出: 6
 * 说明: 6个回文子串: "a", "a", "a", "aa", "aa", "aaa".
 */
public class LeetCode_647_564 {

    public static void main(String[] args) {
        LeetCode_647_564 leetCode = new LeetCode_647_564();
        System.out.println(leetCode.countSubstrings("aaba"));
//        System.out.println(leetCode.countSubstrings1("aaba"));
    }

    /**
     * 动态规划
     * 时间复杂度：O(n ^ 3)
     * 空间复杂度：O(n ^ 2)
     *
     * @param s
     * @return
     */
    public int countSubstrings(String s) {
        int length = s.length();
        if (length == 0) return 0;

        boolean[][] dp = new boolean[length][length];

        int count = 0;
        // 把dp的对角线都置为true，因为一个字母的时候一定是回文子
        for (int i = 0; i < length; i++) {
            count++;
            dp[i][i] = true;
        }

        int left, right;
        boolean current;

        // 循环从1开始，1开始的时候只有两个字母，如果这两个字母相等则为回文
        // 2开始的时候才要判断子串是否回文，子串回文加上现在的相等的字母也回文
        for (int i = 1; i < length; i++) {
            for (int j = 0; j <= length - i - 1; j++) {
                left = j;
                right = i + j;
                // 左右比较
                current = s.charAt(left) == s.charAt(right);
                if (current && (i == 1 || dp[left + 1][right - 1])) {
                    dp[left][right] = true;
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * 分治法
     *
     * 时间复杂度：O(n ^ 2)
     * 空间复杂度：O(1)
     */
    public int countSubstrings1(String s) {
        if (s.length() == 0) return 0;

        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            // 分成偶数向两边扩展
            count += extendPalindrome(s, i, i);
            // 分成奇数向两边扩展
            count +=extendPalindrome(s, i, i + 1);
        }

        return count;
    }

    private int extendPalindrome(String s, int left, int right) {
        int count = 0;
        while (left >= 0 && right < s.length() - 1 && s.charAt(left++) == s.charAt(right--)) count++;
        return count;
    }

}

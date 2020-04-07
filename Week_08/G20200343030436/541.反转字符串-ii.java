/*
 * @lc app=leetcode.cn id=541 lang=java
 *
 * [541] 反转字符串 II
 */

// @lc code=start
class Solution {
    // 我们直接翻转每个 2k 字符块。
    // 每个块开始于 2k 的倍数，也就是 0, 2k, 4k, 6k, ...。需要注意的一件是：如果没有足够的字符，我们并不需要翻转这个块。
    // 为了翻转从 i 到 j 的字符块，我们可以交换位于 i++ 和 j-- 的字符。
    public String reverseStr(String s, int k) {
        char[] a = s.toCharArray();
        for (int start = 0; start < a.length; start += 2 * k) {
            int i = start, j = Math.min(start + k - 1, a.length - 1);
            while (i < j) {
                char tmp = a[i];
                a[i++] = a[j];
                a[j--] = tmp;
            }
        }
        return new String(a);
    }
}
// @lc code=end


/*
 * @lc app=leetcode.cn id=557 lang=java
 *
 * [557] 反转字符串中的单词 III
 */

// @lc code=start
class Solution {
//     就是把字符串转换成char数组，定位每一个单词，然后reverse每个单词。

// 时间复杂度O(n) 虽然有两层while，但只遍历了一遍。
// 空间复杂度O(n)
    public String reverseWords(String s) {
        char[] sentence = s.toCharArray();
        int i = 0, j = 0;
        while(j < sentence.length) {
            while (i < sentence.length && sentence[i] == ' ') {
                i++;
            }
            while (j < sentence.length && sentence[j] != ' ') {
                j++;
            }
            reverse(sentence, i, j - 1);
            i = j;
            ++j;
        }
        s = String.valueOf(sentence);
        return s;
    }

    private void reverse(char[] arr, int start , int end) {
        if (arr.length == 0) {
            return;
        }
        while(start < end) {
            char tmp = arr[start];
            arr[start++] = arr[end];
            arr[end--] = tmp;
        }
    }
}
// @lc code=end


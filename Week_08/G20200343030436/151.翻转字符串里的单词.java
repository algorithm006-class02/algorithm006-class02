import java.util.Arrays;
import java.util.Collections;

/*
 * @lc app=leetcode.cn id=151 lang=java
 *
 * [151] 翻转字符串里的单词
 */

// @lc code=start
class Solution {
    public String reverseWords1(String s) {
        s = s.trim();
        List<String> wordList = Arrays.asList(s.split("\\s+"));
        Collections.reverse(wordList);
        return String.join(" ", wordList);
    }

//     分三步:
// 先翻转整个数组
// 再翻转单个单词
// 清除多余空格
    public String reverseWords(String s) {
        if (s == null) {
            return null;
        }
        char[] s_arr = s.toCharArray();
        int n = s_arr.length;
        //反转数组
        reverse(s_arr, 0, s_arr.length - 1);
        //反转每个单词
        word_reverse(s_arr, n);
        //去除多余空格
        return clean_space(s_arr, n);
    }

    private void reverse(char[] s_arr, int i, int j) {
        while (i < j) {
            char tmp = s_arr[i];
            s_arr[i++] = s_arr[j];
            s_arr[j--] = tmp;
        }
    }

    private void word_reverse(char[] s_arr, int n) {
        int i = 0;
        int j = 0;
        while (i < n) {
            //找到第一个字母
            while (i < n && s_arr[i] == ' ') {
                i++;
            }
            j = i;
            //末位置
            while (j < n && s_arr[j] != ' ') {
                j++;
            }
            reverse(s_arr, i, j - 1);
            i = j;
        }
    }

    private String clean_space(char[] s_arr, int n) {
        int i = 0;
        int j = 0;
        while (j < n) {
            while (j < n && s_arr[j] == ' ') {
                j++;
            }
            while (j < n && s_arr[j] != ' ') {
                s_arr[i++] = s_arr[j++];
            }
            while (j < n && s_arr[j] == ' ') {
                j++;
            }
            if (j < n) {
                s_arr[i++] = ' ';
            }
        }
        return new String(s_arr).substring(0, i);
    }
}
// @lc code=end


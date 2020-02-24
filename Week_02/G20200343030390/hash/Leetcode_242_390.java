/**
 * 242.有效的字母异位词
 *
 *给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 示例 1:
 *
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 *
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 说明:
 * 你可以假设字符串只包含小写字母。
 *
 * 进阶:
 * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 *
 *
 *  思路（精简）：
 *  两个字符串长度必须相等
 *
 *  1.排序
 *  字符串转成char[]数组 排序 比较是否相等
 *
 *  时间复杂度：O(nlogn)，假设 n 是 s 的长度，排序成本 O(nlogn) 和比较两个字符串的成本O(n)。排序时间占主导地位，总体时间复杂度为O(nlogn)。
 *  空间复杂度：
 *  O(1)，空间取决于排序实现，如果使用 heapsort，通常需要 O(1) 辅助空间。注意，在 Java 中，toCharArray() 制作了一个字符串的拷贝，所以它花费O(n) 额外的空间，
 * 但是我们忽略了这一复杂性分析，因为：
 * 这依赖于语言的细节。
 * 这取决于函数的设计方式。例如，可以将函数参数类型更改为 char[]。
 *

 *  2.计数器
 *   (1)26个字母
 *      遍历字符串 字母-'a'作为数组下标 个数++ --
 *      遍历计数器 不为0直接返回
 *  （2）26个字母  遍历s 个数++ 遍历t 个数-- 如果< 0 直接返回
 *
 *  时间复杂度 O(n)
 *  空间复杂度 O(1)
 *
 *
 *
 */
public class Leetcode_242_390 {

    /**
     * 1.排序比较相等
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagramOne(String s, String t) {
        if(s.length()!= t.length()) {
            return false;
        }
        char[] charS = s.toCharArray();
        char[] charT = t.toCharArray();
        Arrays.sort(charS);
        Arrays.sort(charT);
        for(int i = 0; i< s.length(); i++) {
            if(charS[i] != charT[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * 2.计数器 key 字母对应的数组下标 value 字母个数
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagramTwo(String s, String t) {
        if(s.length()!= t.length()) {
            return false;
        }
        // 26个小写字母
        int[] count = new int[26];
        /*
        for(int i = 0; i < s.length(); i++) {
            count[s.charAt(i)-'a']++;
            count[t.charAt(i)-'a']--;
        }
        for(int c:count){
            if(c != 0) {
                return false;
            }
        }*/

        for(int i = 0; i < s.length(); i++) {
            count[s.charAt(i)-'a'] ++;
        }
        for(int j = 0; j < t.length(); j++) {
            count[t.charAt(j)-'a'] --;
            if(count[t.charAt(j)-'a'] < 0) {
                return false;
            }
        }

        return true;
    }

}
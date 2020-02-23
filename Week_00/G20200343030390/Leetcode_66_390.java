/**
 *
 * 66.加一（简单）
 *
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 * 示例 1:
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 *
 * 示例 2:
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321
 *
 *
 * 思路（精简）：
 * 数字分为
 *   （1）除9以外的正整数 直接+1
 *   （2）数字9  变成0 扩充数组 首位 1
 *   时间复杂度O(n)
 *
 *
 */
public class Leetcode_66_390 {

    public static int[] plusOne(int[] digits) {
        for(int i=digits.length-1; i>=0; i--) {
            // 小于9 < 9 / 非9 != 9
            if(digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            // 9
            digits[i] = 0;
        }
        // 处理 99 999...
        if(digits[0] == 0) {
            digits = new int [digits.length+1];
            digits[0] = 1;
        }
        return digits;
    }
}

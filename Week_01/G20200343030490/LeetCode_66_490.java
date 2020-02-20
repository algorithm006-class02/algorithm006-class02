/**
 * @author:
 * @Date: 2020-02-14 18:20
 * @Copyright: 2019 www.lenovo.com Inc. All rights reserved.
 */

//给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
//
// 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
//
// 你可以假设除了整数 0 之外，这个整数不会以零开头。
//
// 示例 1:
//
// 输入: [1,2,3]
//输出: [1,2,4]
//解释: 输入数组表示数字 123。
//
//
// 示例 2:
//
// 输入: [4,3,2,1]
//输出: [4,3,2,2]
//解释: 输入数组表示数字 4321。
//
// Related Topics 数组
public class LeetCode_66_490 {
    /**
     * 从后向前遍历 ++ 每个位置%10如果不为零直接返回，如果为零继续 loop
     * @param digits
     * @return
     */
    public int[] plusOne(int[] digits) {
        for(int i = digits.length-1 ; i >= 0 ;i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if(digits[i] != 0){
                return digits;
            }
        }
        int[] result = new int[digits.length + 1];
        result[0] = 1;
        return result;

    }
}

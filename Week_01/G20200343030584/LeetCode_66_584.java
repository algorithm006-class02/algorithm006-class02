/**
 * 66. 加一
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * <p>
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * <p>
 * 示例 1:
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123，123 + 1 = 124。
 * <p>
 * 链接：https://leetcode-cn.com/problems/plus-one
 */
public class PlusOne {
    public static void test() {
//        int[] digits = new int[]{1, 2, 9};
//        int[] digits = new int[]{9, 9, 9};
        int[] digits = new int[]{1, 2, 4};
        PlusOne plusOne = new PlusOne();
        Utils.printArray(plusOne.plusOne3(digits));
    }

    public int[] plusOne(int[] digits) {
        //暴力法
        // 从后往前遍历，遇9计数+1,非9则结束循环
        // 后面再对9的数量分情况处理返回数组：
        // 1.全部是9，则+1之后将是10的整数倍，且数组元素将多出一位；
        // 2.部分元素是9，此部分元素+1之后将全部是0
        int left = 0;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] == 9) {
                left++;
            } else
                break;
        }
        if (left == digits.length) {
            int[] result = new int[left + 1];
            result[0] = 1;
            return result;
        } else {
            int pos = digits.length - left - 1;
            digits[pos] = digits[pos] + 1;
            for (int i = digits.length - left; i < digits.length; i++) {
                digits[i] = 0;
            }
            return digits;
        }
    }

    public int[] plusOne2(int[] digits) {
        // 一次循环+标记 从后往前,碰到9计数+1且将之置为0，非9则将之加1，结束循环
        int left = 0;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] == 9) {
                digits[i] = 0;
                left++;
            } else {
                digits[i] = digits[i] + 1;
                break;
            }
        }
        // 特别情况
        if (left == digits.length) {
            int[] result = new int[digits.length + 1];
            result[0] = 1;
            return result;
        }
        return digits;
    }

    public int[] plusOne3(int[] digits) {
        // 一次循环-无标记优化版 从后往前,碰到9将之置为0，非9则将之加1，结束程序
        for (int i = digits.length - 1; i >= 0; i--) {
            // 还有一种处理方式是对10取余
            if (digits[i] == 9) {
                digits[i] = 0;
            } else {
                digits[i] = digits[i] + 1;
                return digits;
            }
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
}

package week8;

import java.util.Stack;

/**
 * 917. 仅仅反转字母
 * 给定一个字符串 S，返回 “反转后的” 字符串，其中不是字母的字符都保留在原地，而所有字母的位置发生反转。
 * <p>
 * 示例 1：
 * 输入："ab-cd"
 * 输出："dc-ba"
 * <p>
 * 示例 2：
 * 输入："a-bC-dEf-ghIj"
 * 输出："j-Ih-gfE-dCba"
 * <p>
 * 示例 3：
 * 输入："Test1ng-Leet=code-Q!"
 * 输出："Qedo1ct-eeLg=ntse-T!"
 * <p>
 * https://leetcode-cn.com/problems/reverse-only-letters/
 */
public class ReverseOnlyLetters {
    public static void test() {
        String s = "Test1ng-Leet=code-Q!";
        System.out.println("反转之后：" + new ReverseOnlyLetters().reverseOnlyLetters2(s));
    }

    public String reverseOnlyLetters(String S) {
        // 双指针法
        if (S == null || S.length() <= 1) return S;
        int length = S.length();
        int i = 0;
        int j = length - 1;
        char[] chars = S.toCharArray();
        while (i < j) {
            boolean isLetterI = Character.isLetter(chars[i]);
            boolean isLetterJ = Character.isLetter(chars[j]);
            if (isLetterI && isLetterJ) {
                char temp = chars[i];
                chars[i++] = chars[j];
                chars[j--] = temp;
                continue;
            }
            if (!isLetterI) {
                i++;
            }
            if (!isLetterJ) {
                j--;
            }
        }
        return new String(chars);
    }

    public String reverseOnlyLetters2(String S) {
        // 栈字母栈
        //将 s 中的所有字母单独存入栈中，所以出栈等价于对字母反序操作。（或者，可以用数组存储字母并反序数组。）
        //然后，遍历 s 的所有字符，如果是字母我们就选择栈顶元素输出。
        if (S == null || S.length() <= 1) return S;
        Stack<Character> stack = new Stack<>();
        for (char c : S.toCharArray()) {
            if (Character.isLetter(c)) {
                stack.push(c);
            }
        }
        int length = S.length();
        StringBuilder builder = new StringBuilder(length);
        int i = 0;
        while (i < length) {
            char ch = S.charAt(i++);
            if (Character.isLetter(ch))
                builder.append(stack.pop());
            else
                builder.append(ch);
        }
        return builder.toString();
    }
}

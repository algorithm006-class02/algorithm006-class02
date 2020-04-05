//给定一个字符串，逐个翻转字符串中的每个单词。
//
//
//
// 示例 1：
//
// 输入: "the sky is blue"
//输出: "blue is sky the"
//
//
// 示例 2：
//
// 输入: "  hello world!  "
//输出: "world! hello"
//解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
//
//
// 示例 3：
//
// 输入: "a good   example"
//输出: "example good a"
//解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
//
//
//
//
// 说明：
//
//
// 无空格字符构成一个单词。
// 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
// 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
//
//
//
//
// 进阶：
//
// 请选用 C 语言的用户尝试使用 O(1) 额外空间复杂度的原地解法。
// Related Topics 字符串


class Solution151 {
    public String reverseWords(String s) {
        // 负负得正
        // 先全部反转
        // 再按单词反转

        char[] chars = s.trim().toCharArray(); // trim 去除首尾空格

        for (int i = 0, j = chars.length - 1; i < j; i++, j--) {
            char tmp = chars[i];
            chars[i] = chars[j];
            chars[j] = tmp;
        }

        String reversedS = new String(chars);
        String[] words = reversedS.split("\\s+"); // 注意匹配空格的正则表达式写法。\s表示匹配任何空白字符，+表示匹配一次或多次
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            char[] charArray = word.toCharArray();
            for (int j = 0, k = charArray.length - 1; j < k; j++, k--) {
                char tmp = charArray[j];
                charArray[j] = charArray[k];
                charArray[k] = tmp;
            }
            sb.append(new String(charArray));
            sb.append(" ");
        }
        sb.deleteCharAt(sb.toString().length() - 1);

        return sb.toString();
    }
}

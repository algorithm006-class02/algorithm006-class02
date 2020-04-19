//给定一个字符串和一个整数 k，你需要对从字符串开头算起的每个 2k 个字符的前k个字符进行反转。如果剩余少于 k 个字符，则将剩余的所有全部反转。如果有小于
// 2k 但大于或等于 k 个字符，则反转前 k 个字符，并将剩余的字符保持原样。
//
// 示例:
//
//
//输入: s = "abcdefg", k = 2
//输出: "bacdfeg"
//
//
// 要求:
//
//
// 该字符串只包含小写的英文字母。
// 给定字符串的长度和 k 在[1, 10000]范围内。
//
// Related Topics 字符串


class Solution541 {
    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        int n = 0;

        for (n = 0; n < s.length() / (2 * k); n++) {
            for (int i = n * 2 * k, j = i + k - 1; i < j; i++, j--) {
                char tmp = chars[i];
                chars[i] = chars[j];
                chars[j] = tmp;
            }
        }

        for (int i = n * 2 * k, j = i + k - 1; i < j; i++, j--) {
            if (j > s.length() - 1)
                j = s.length() - 1;
            if (i > j)
                break;
            char tmp = chars[i];
            chars[i] = chars[j];
            chars[j] = tmp;
        }

        return new String(chars);
    }

    public static void main(String[] args) {
        Solution541 sln = new Solution541();
        System.out.println(sln.reverseStr("abcd", 2));
    }
}

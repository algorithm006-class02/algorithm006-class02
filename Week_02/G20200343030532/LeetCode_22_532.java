//给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
//
// 例如，给出 n = 3，生成结果为：
//
// [
//  "((()))",
//  "(()())",
//  "(())()",
//  "()(())",
//  "()()()"
//]
//
// Related Topics 字符串 回溯算法


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        _generate(0, 0, n, "", res);
        return res;
    }

    private static void _generate(int left, int right, int max, String s, List<String> res) {

        // 最终终止条件边界添加001
        if (left == max && right == max) {
            res.add(s);
            return;
        }

        // 当前层次
//        String left = s + "(";
//        String right = s + "}";

        // 传递给下一个层次

        // 最终终止条件边界添加002
        if (left < max)
            _generate(left + 1, right, max, s + "(", res);

        // 最终终止条件边界添加003
        if (left > right)
            _generate(left, right + 1, max, s + ")", res);

        // 清除状态

    }
}
//leetcode submit region end(Prohibit modification and deletion)

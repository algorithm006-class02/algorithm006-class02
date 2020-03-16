import java.util.LinkedList;

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new LinkedList<>();
        helper(n, 0, 0, "", res);
        return res;
    }
    private void helper(int n, int left, int right, String s, List<String> res) {
        if (left == n && right == n) {
            res.add(s);
            return;
        }
        if (left < n) {
            helper(n, left + 1, right, s + "(", res);
        }
        if (right < left) {
            helper(n, left, right + 1, s + ")", res);
        }
    }
}
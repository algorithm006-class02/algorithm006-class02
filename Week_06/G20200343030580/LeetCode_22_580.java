class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generateParenthesis("", 0, 0, n, result);
        return result;
    }

    private void generateParenthesis(String c, int left, int right, int n, List<String> result) {
        if (right == n) {
            result.add(c);
            return;
        }
        if (left < n) {
            generateParenthesis(c + "(", left + 1, right, n, result);
        }
        if (right < left) {
            generateParenthesis(c + ")", left, right + 1, n, result);
        }
    }
}

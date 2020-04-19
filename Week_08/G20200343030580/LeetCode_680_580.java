class Solution {
    public boolean validPalindrome(String s) {
        return validPalindrome(s.toCharArray(), 0, s.length() - 1, 0);
    }

    private boolean validPalindrome(char[] s, int left, int right, int moveCount) {
        for (int i = left, j = right; i < j; ) {
            if (s[i] == s[j]) {
                i++;
                j--;
            } else {
                if (moveCount > 0) {
                    return false;
                }
                return validPalindrome(s, i + 1, j, 1) || validPalindrome(s, i, j - 1, 1);
            }
        }
        return true;
    }
}
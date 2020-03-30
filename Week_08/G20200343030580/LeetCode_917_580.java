class Solution {
    public String reverseOnlyLetters(String S) {
        char[] sc = S.toCharArray();
        reverseString(sc);
        return new String(sc);
    }

    public void reverseString(char[] s) {
        for (int i = 0, j = s.length - 1; i < j; ) {
            boolean iL = isLetter(s[i]);
            boolean jL = isLetter(s[j]);
            if (iL && jL) {
                char tmp = s[i];
                s[i] = s[j];
                s[j] = tmp;
                i++;
                j--;
            }
            if (iL == false) {
                i++;
            }
            if (jL == false) {
                j--;
            }
        }
    }

    private boolean isLetter(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }
}
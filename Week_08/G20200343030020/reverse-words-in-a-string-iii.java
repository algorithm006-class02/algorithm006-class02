class Solution {
    public String reverseWords(String s) {
        char[] ca = s.toCharArray();
        for (int i = 0; i < ca.length; i++) {
            if (ca[i] != ' ') {
                int j = i;
                while (j + 1 < ca.length && ca[j + 1] != ' ') { j++; }
                reverse(ca, i, j);
                i = j;
            }
        }
        return new String(ca);
    }
    private void reverse(char[] ca, int i, int j) {
        for (; i < j; i++, j--) {
            char tmp = ca[i];
            ca[i] = ca[j];
            ca[j] = tmp;
        }
    }
}
class Solution {
    public String reverseWords(String s) {
        char[] sc = s.toCharArray();
        int index = 0;
        while (true) {
            int i = s.indexOf(" ", index);
            if (i == -1) {
                reverseString(sc, index, sc.length - 1);
                break;
            } else {
                reverseString(sc, index, i - 1);
                index = i + 1;
            }
        }
        return new String(sc);
    }

    private void reverseString(char[] s, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            char tmp = s[i];
            s[i] = s[j];
            s[j] = tmp;
        }
    }
}
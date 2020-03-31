class Solution {
    public String reverseWords(String s) {
        char[] result = new char[s.length()];
        int count = 0;
        for (int i = s.length() - 1; i > -1; i--) {
            if (s.charAt(i) != ' ' || (count != 0 && result[count - 1] != ' ')) {
                result[count++] = s.charAt(i);
            }
        }
        if (count > 0 && result[count - 1] == ' ') {
            count--;
        }
        for (int i = 0, j = 0; i < count; i++) {
            if (result[i] == ' ') {
                reverseString(result, j, i - 1);
                j = i + 1;
            } else if (i == count - 1) {
                reverseString(result, j, i);
            }
        }
        return new String(result, 0, count);
    }

    private void reverseString(char[] s, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            char tmp = s[i];
            s[i] = s[j];
            s[j] = tmp;
        }
    }
}
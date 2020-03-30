class Solution {
    public String reverseStr(String s, int k) {
        char[] sc = s.toCharArray();
        reverseStr(sc, k, 0, sc.length - 1);
        return new String(sc);
    }

    public void reverseStr(char[] s, int k, int start, int end) {
        int length = end - start + 1;
        if (length <= k) {
            reverseString(s, start, end);
        } else if (length < 2 * k) {
            reverseString(s, start, start + k - 1);
        } else {
            reverseString(s, start, start + k - 1);
            reverseStr(s, k, start + 2 * k, end);
        }
    }

    public void reverseString(char[] s, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            char tmp = s[i];
            s[i] = s[j];
            s[j] = tmp;
        }
    }
}
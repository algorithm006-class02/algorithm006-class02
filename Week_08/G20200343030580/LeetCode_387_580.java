class Solution {
    public int firstUniqChar(String s) {
        int[] table = new int[256];
        char[] cs = s.toCharArray();
        for (char c : cs) {
            table[c]++;
        }
        for (int i = 0; i < cs.length; i++) {
            if (table[cs[i]] == 1) {
                return i;
            }
        }
        return -1;
    }
}
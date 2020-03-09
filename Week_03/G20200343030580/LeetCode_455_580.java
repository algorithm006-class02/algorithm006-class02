class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int i = 0;
        int j = 0;
        int result = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        while (i < g.length && j < s.length) {
            if (g[i] <= s[j]) {
                result++;
                i++;
                j++;
            } else {
                j++;
            }
        }
        return result;
    }
}

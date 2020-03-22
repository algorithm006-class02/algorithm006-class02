class Solution {
    public int numDecodings(String s) {
        char[] sa = s.toCharArray();
        int n = sa.length;
        if (n == 0) return 1;

        int[] f = new int[n +1];
        f[0] = 1;

        for (int i = 1; i <= n; i++){
            if (sa[i - 1] >= '1' && sa[i - 1] <= '9'){
                f[i] += f[i-1];
            }

            if (i > 1){
                int j = 10 * (sa[i-2] - '0') + (sa[i-1] - '0');
                if (j >= 10 && j <= 26){
                    f[i] += f[i-2];
                }
            }
        }

        return f[n];
    }
}
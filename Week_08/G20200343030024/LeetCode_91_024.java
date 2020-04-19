class Solution {
    public int numDecodings(String s) {
        char[] sa = s.toCharArray();
        int M = sa.length;
        int[] F =new int[M+1];
        F[0] = 1;
        // DP 
        // F(N) = F(N-1) + F(N-2);
        for (int i = 1; i < M+1; i++){
            if (sa[i - 1] >= '1' && sa[i-1] <= '9'){
                F[i] += F[i-1];
            }

            if (i > 1){
                int value  = (sa[i-2] - '0') * 10 + (sa[i-1] - '0');
                if (value >= 10 && value <=26){
                    F[i] += F[i-2];
                }
            }
        }

        return F[M];
    }
}
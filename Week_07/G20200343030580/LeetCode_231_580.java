class Solution {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && hammingWeight(n) == 1;
    }

    private int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            n = n & (n - 1);
            count++;
        }
        return count;
    }
}

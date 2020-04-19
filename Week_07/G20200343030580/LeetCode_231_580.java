class Solution {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (int) (n & (n - 1)) == 0;
    }
}

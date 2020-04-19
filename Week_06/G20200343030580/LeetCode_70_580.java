class Solution {
    public int climbStairs(int n) {
        if (n == 0) {
            return 0;
        }
        int[] cache = new int[n + 1];
        return climbStairs(n, cache);
    }

    private int climbStairs(int n, int[] cache) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        if (cache[n] != 0) {
            return cache[n];
        }
        cache[n] = climbStairs(n - 2, cache) + climbStairs(n - 1, cache);
        return cache[n];
    }
}

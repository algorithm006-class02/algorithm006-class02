//70-climbing-stairs

class Solution {
public:
    int climbStairs(int n) {
        if (n <= 3) return n;
        vector<int> f(n+1);
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i <= n; ++i) {
            f[i] = f[i-1] + f[i-2];
        }
        return f[n];
    }
};


class Solution2 {
public:
    int climbStairs(int n) {
        if (n <= 3) return n;
        int a = 1, b = 1, c = 2;
        while (--n) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }
};

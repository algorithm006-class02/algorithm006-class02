import java.util.Map;

class Solution {
    Map<Integer, Integer> memory = new HashMap<Integer, Integer>();
    
    public int climbStairs(int n) {
        // f(n) = f(n - 2) + f(n - 1)
        // f(3) = f(2) + f(1)
        // f(2) = 2, f(1) = 1
       if (n < 3) {
           return n;
       }
       int first = 1;
       int second = 2;
       int ret = 0;
       for (int i = 3; i <= n; i++) {
            ret = first + second;
            first = second;
            second = ret;
       }
       return second;
    }
}
/**
 * 70. 爬楼梯
 * 
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 */

class Solution {

    public int climbStairs(int n) {

        if (n <= 2) { return n; }
        
        int prev1 = 1, prev2 = 2;
        int result = prev1 + prev2;

        for (int i = 3; i <= n; i++) {
            result = prev1 + prev2;
            int temp = prev2;
            prev2 = result;
            prev1 = temp;
        }

        return result;
    }
}
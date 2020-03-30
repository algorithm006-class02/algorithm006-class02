/*
 * @lc app=leetcode.cn id=231 lang=java
 *
 * [231] 2的幂
 */

// @lc code=start
class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n == 0) {
            return false;
        }
        long x = (long)n;
        return (x & (x - 1)) == 0;
    }
}

//class Solution {
    // func isPowerOfTwo(_ n: Int) -> Bool {
    //     if (n == 0) {
    //         return false
    //     }
    //     let x = n
    //     return (x & (x - 1)) == 0
    // }
//}
// @lc code=end


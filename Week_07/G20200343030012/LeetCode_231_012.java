/**
 * 231. 2的幂
 * 给定一个整数，编写一个函数来判断它是否是 2 的幂次方。
 */

class Solution {
    public boolean isPowerOfTwo(int n) {

        if (n == 0) { return false; }
        
        while (n % 2 == 0) {
            n = n / 2;
        }

        return n == 1;
    }
}
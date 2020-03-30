package week07.pratice;

/**
 * 2的幂
 * 给定一个整数，编写一个函数来判断它是否是 2 的幂次方。
 *
 * 示例 1:
 * 输入: 1
 * 输出: true
 * 解释: 2^0 = 1
 *
 * 示例 2:
 * 输入: 16
 * 输出: true
 * 解释: 2^4 = 16
 *
 * 示例 3:
 * 输入: 218
 * 输出: false
 *
 */
public class LeetCode_231_564 {

    public static void main(String[] args) {
        LeetCode_231_564 leetCode = new LeetCode_231_564();
        System.out.println(leetCode.isPowerOfTwo(16));
    }

    /**
     * 位运算
     * 时间复杂度：O(1)
     * 空间复杂度：O(1)
     *
     * @param n
     * @return
     */
    public boolean isPowerOfTwo(int n) {
        // n 如果是2的次幂，则最高位是1，其余位都是0，n-1则相反
        // n 与 n-1 & 运算，& 是为1才为1，如果两个与为0，则是2的幂
        return n > 0 && (n & (n - 1)) == 0;
    }
}

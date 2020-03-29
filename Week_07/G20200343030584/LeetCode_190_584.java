package week7;

/**
 * 190. 颠倒二进制位
 * 颠倒给定的 32 位无符号整数的二进制位。
 * <p>
 * 示例 1：
 * 输入: 00000010100101000001111010011100
 * 输出: 00111001011110000010100101000000
 * 解释: 输入的二进制串 00000010100101000001111010011100 表示无符号整数 43261596，
 * 因此返回 964176192，其二进制表示形式为 00111001011110000010100101000000。
 * <p>
 * https://leetcode-cn.com/problems/reverse-bits/
 */
public class ReverseBits {
    public static void test() {
        new ReverseBits().reverseBits(1);
    }

    /**
     * https://leetcode-cn.com/problems/reverse-bits/solution/yi-dong-zui-hou-yi-wei-dao-di-yi-wei-4-xing-dai-ma/
     *
     * @param n
     * @return
     */
    public int reverseBits(int n) {
        int result = 0;
        for (int i = 31; n != 0; n = n >>> 1, i--) {
            result += (n & 1) << i;
        }
        return result;
    }

    /**
     * https://leetcode-cn.com/problems/reverse-bits/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-4-9/
     *
     * @param n
     * @return
     */
    public int reverseBits2(int n) {
        int res = 0;
        int count = 0;
        while (count < 32) {
            res <<= 1;  //res 左移一位空出位置
            res |= (n & 1); //得到的最低位加过来
            n >>= 1;//原数字右移一位去掉已经处理过的最低位
            count++;
        }
        return res;
    }
}

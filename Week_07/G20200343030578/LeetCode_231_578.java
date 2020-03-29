//给定一个整数，编写一个函数来判断它是否是 2 的幂次方。
//
// 示例 1:
//
// 输入: 1
//输出: true
//解释: 20 = 1
//
// 示例 2:
//
// 输入: 16
//输出: true
//解释: 24 = 16
//
// 示例 3:
//
// 输入: 218
//输出: false
// Related Topics 位运算 数学


class Solution231 {
    public boolean isPowerOfTwo(int n) {
        // 2 次幂的二进制形式中仅仅含有 1 个 1，其他都为 0
        // 判断 n 是否大于 0 并且二进制数中只有 1 个 1 即可
        int cnt = 0;
        int x = n;

        while (x != 0) {
            x &= (x - 1);
            cnt++;
        }

        return (n > 0) && cnt == 1;
    }
}

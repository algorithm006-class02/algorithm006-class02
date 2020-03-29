/**
 * https://leetcode-cn.com/problems/reverse-bits/
 * @author : Hyuk
 * @description : LeetCode_190_536
 * @date : 2020/3/28 10:31 下午
 */
public class LeetCode_190_536 {

    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; ++i) {
            res = (n & 1) + (res << 1);
            n = n >> 1;
        }
        return res;
    }
}

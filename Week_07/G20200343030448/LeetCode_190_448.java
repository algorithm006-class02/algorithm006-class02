package G20200343030448;

public class LeetCode_190_448 {
    public int reverseBits(int n) {
        int res = 0;
        for (int i = 31; n != 0; i--) {
            res += (n & 1) << i; //取出n的最后一位，左移到对应位置。
            n >>>= 1; //n无符号右移，给出下一个待操作的位
        }
        return res;
    }
}

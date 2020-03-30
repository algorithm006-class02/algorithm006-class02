public class LeetCode_190_600 {
    public int reverseBits1(int n) {
        //方法一：移动最后一位到第一位，循环右移n, 每次获取最右位，左移到相应高位
        int bit = 0;
        for(int bitSize = 31; n > 0; n = n >>> 1, bitSize--) {
            bit |= (n & 1) << bitSize;
        }
        return bit;
    }

    public int reverseBits2(int n) {
        //方法二：结果左移空出最右位，取最右一位添加到结果中，
        int ans = 0, count = 0;
        while(count < 32) {
            ans <<= 1;
            ans += n & 1;
            n >>= 1;
            count++;
        }
        return ans;
    }
}

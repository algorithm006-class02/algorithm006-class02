/**
 * @Author ：zhenghaoran.
 * @Date ：Created in 17:41 2020/3/29
 * @Description：
 */
public class LeetCode_190_022 {
    public int reverseBits(int n) {
        int ans = 0;
        for (int bitsSize = 31; n != 0; n = n >>> 1, bitsSize--) {
            ans += (n & 1) << bitsSize;
        }
        return ans;

    }
}

/**
 * https://leetcode-cn.com/problems/power-of-two/
 * @author : Hyuk
 * @description : LeetCode_231_536
 * @date : 2020/3/28 10:14 下午
 */
public class LeetCode_231_536 {

    public boolean isPowerOfTwo(int n) {
        return n != 0 && (n & (n - 1)) == 0;
    }
}

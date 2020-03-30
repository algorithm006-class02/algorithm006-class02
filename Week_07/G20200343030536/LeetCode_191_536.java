/**
 * https://leetcode-cn.com/problems/number-of-1-bits/
 * @author : Hyuk
 * @description : LeetCode_191_536
 * @date : 2020/3/28 10:11 下午
 */
public class LeetCode_191_536 {

    public int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            res &= (res - 1);
            res++;
        }
        return res;
    }
}

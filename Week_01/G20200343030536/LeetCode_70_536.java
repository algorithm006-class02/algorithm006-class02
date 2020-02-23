/**
 * @author : Hyuk
 * @description : LeetCode_70_536
 * @date : 2020/2/15 2:16 下午
 */
public class LeetCode_70_536 {

    public int climbStairs(int n) {
        if (n < 0) {
            throw new RuntimeException("n小于0");
        }
        if (n == 1 || n == 2) {
            return n;
        }

        int f1 = 1, f2 = 2;
        int result = 0;
        for (int i = 3; i <= n; ++i) {
            result = f1 + f2;
            f1 = f2;
            f2 = result;
        }

        return result;
    }
}

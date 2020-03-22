package G20200343030372;

/**
 * @author Chen.C
 * @date 2020/3/19
 */
public class Climbing_stairs_70 {

    public int climbStairs(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int a = 1;
        int b = 2;
        int result = 0;
        for (int i = 2; i < n; i++) {
            result = a + b;
            a = b;
            b = result;
        }
        return result;
    }
}

package G20200343030372;

/**
 * @author Chen.C
 * @date 2020/3/24
 */
public class Power_of_two_231 {

    public boolean isPowerOfTwo(int n) {
        if (n == 0) return false;
        return ((long) n & (-(long) n)) == (long) n;
    }

}

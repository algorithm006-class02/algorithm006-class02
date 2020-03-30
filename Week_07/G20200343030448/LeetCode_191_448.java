package G20200343030448;

public class LeetCode_191_448 {
    public long hammingWeight(long n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = n & (n - 1);
        }
        return count;

/*        int count = 0;
        while (n != 0) {
            count += n & 1;
            n = n>>1;
        }
        return count;*/
    }
}

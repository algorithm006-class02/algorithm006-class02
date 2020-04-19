public class LeetCode_191_600 {
    public int hammingWeight(int n) {
        int count = 0;
        while(n > 0) {
            n &= n - 1;
            count++;
        }
        return count;
    }
}

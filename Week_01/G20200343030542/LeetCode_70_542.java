
import java.util.HashMap;
import java.util.Map;

public class ClimbingStair {

    public int climbStairs(int n) {
        Map<Integer, Integer> cache = new HashMap<>(16);
        cache.put(1, 1);
        cache.put(2, 2);
        return climbStairsInternal(n, cache);
    }

    private int climbStairsInternal(int n, Map<Integer, Integer> cache) {
        Integer stepNumber = cache.get(n);
        if (stepNumber != null) {
            return stepNumber;
        }
        stepNumber = climbStairsInternal(n - 1, cache) + climbStairsInternal(n - 2, cache);
        cache.put(n, stepNumber);
        return stepNumber;
    }
}
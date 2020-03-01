package Week_02.G20200343030492;
import java.util.*;
/**
 * LeetCode_77_492
 */
public class LeetCode_77_492 {

	List<List<Integer>> output = new LinkedList<>();
    int n;
	int k;
	
    public List<List<Integer>> combine(int n, int k) {
        this.n = n;
        this.k = k;
        backtrack(1, new LinkedList<>());
        return output;
    }

    private void backtrack(int first, LinkedList<Integer> cur) {
        if (cur.size() == k) {
            output.add(new LinkedList(cur));
        }
        for (int i = first; i <= n; i++) {
            cur.add(i);
            backtrack(i + 1, cur);
            cur.removeLast();
        }
    }
}
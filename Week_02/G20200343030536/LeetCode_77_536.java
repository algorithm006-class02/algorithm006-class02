import java.util.ArrayList;
import java.util.List;

/**
 * @author : Hyuk
 * @description : LeetCode_77_536
 * @date : 2020/2/23 7:46 下午
 */
public class LeetCode_77_536 {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (k == 0) { return res; }
        List<Integer> tmp = new ArrayList<>();
        dfs(n, k, 0, res, tmp);
        return res;
    }

    private void dfs(int n, int k, int start, List<List<Integer>> res, List<Integer> tmp) {
        if (tmp.size() == k) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = start; i <= n; ++i) {
            tmp.add(i);
            dfs(n, k, i + 1, res, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }
}

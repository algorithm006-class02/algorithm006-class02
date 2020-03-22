import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new LinkedList<>();
        helper(1, n, k, new LinkedList<Integer>(), res);
        return res;
    }

    public void helper(int start, int n, int k, LinkedList<Integer> curr, List<List<Integer>> res) {
        if (curr.size() == k) {
            System.out.println(curr.toString());
            res.add(new LinkedList<>(curr));
            return ;
        }

        for (int i = start; i <= n; i++) {
            curr.add(i);
            helper(i + 1, n, k, curr, res);
            curr.removeLast();
        }

    }

    
}
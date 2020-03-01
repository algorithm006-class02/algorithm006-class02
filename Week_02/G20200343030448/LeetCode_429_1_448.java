package G20200343030448;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetCode_429_1_448 {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue q = new LinkedList<Node>();
        q.add(root);
        while (!q.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int temploop = q.size();
            for (int i = 0; i < temploop; i++) {
                Node n = (Node) q.poll();
                level.add(n.val);
                for (int temp = 0; temp < n.children.size(); temp++) {
                    q.add(n.children.get(temp));
                }
            }
            result.add(level);
        }
        return result ;
    }
}

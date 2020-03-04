import java.util.*;

/**
 * @author : Hyuk
 * @description : LeetCode_429_536
 * @date : 2020/2/22 12:10 上午
 */
public class LeetCode_429_536 {

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Queue<Node> stack = new LinkedList<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            List<Integer> tmpList = new ArrayList<>();
            int size = stack.size();
            for (int i = 0; i < size; ++i) {
                Node node = stack.poll();
                stack.addAll(node.children);
                tmpList.add(node.val);
            }
            res.add(tmpList);
        }
        return res;
    }
}

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetCode_102_378 {
    public List<List<Integer>> levelOrderI(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        if (null == root)
            return lists;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                TreeNode poll = queue.poll();
                list.add(poll.val);
                if (null != poll.left) queue.offer(poll.left);
                if (null != poll.right) queue.offer(poll.right);
            }
            lists.add(list);
        }
        return lists;
    }

    List<List<Integer>> levels = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (null == root)
            return levels;
        helper(root, 0);
        return levels;
    }

    private void helper(TreeNode root, int level) {
        //terminator
        if(null == root)
            return;
        //....
        if (levels.size() == level)
            levels.add(new ArrayList<>());

        //process
        levels.get(level).add(root.val);
        //dirll down
        helper(root.left, level + 1);
        helper(root.right, level + 1);

    }
}

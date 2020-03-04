import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetCode_515_378 {
    public List<Integer> largestValuesI(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        helper(0, ret, root);
        return ret;
    }

    private void helper(int level, List<Integer> ret, TreeNode node) {
        //terminator
        if (null == node)
            return;

        //process
        if (level == ret.size())
            ret.add(node.val);
        else
            ret.set(level, Math.max(ret.get(level), node.val));

        //dirll down
        helper(level + 1, ret, node.left);
        helper(level + 1, ret, node.right);
    }

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        if (null == root)
            return ret;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int max = Integer.MIN_VALUE;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                max = Math.max(max,poll.val);
                if(null != poll.right) queue.offer(poll.right);
                if(null != poll.left) queue.offer(poll.left);
            }
            ret.add(max);
        }
        return ret;
    }


}

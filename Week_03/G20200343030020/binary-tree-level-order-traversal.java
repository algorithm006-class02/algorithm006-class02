public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

//广度优先
class Solution {
    List<List<Integer>> levels = new ArrayList<List<Integer>>();

    public void helper(TreeNode node, int level) {
        //添加当前节点
        if (levels.size() == level) levels.add(new ArrayList<Integer>());
        levels.get(level).add(node.val);
        //处理当前节点的next节点
        if (node.left != null) helper(node.left, level + 1);
        if (node.right != null) helper(node.right, level + 1);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return levels;
        helper(root, 0);
        return levels;
    }
}

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levels = new ArrayList<List<Integer>>();
        if (root == null) return levels;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int level = 0;
        while (!queue.isEmpty()) { //遍历手动维护的队列
            levels.add(new ArrayList<Integer>());
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                TreeNode node = queue.remove();
                levels.get(level).add(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            level++;
        }
        return levels;
    }
}

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levels = new ArrayList<List<Integer>>();
        levelHelper(root, 0, levels);
        return levels;
    }

    public void levelHelper(TreeNode root, int level, List<List<Integer>> levels) {
        if (root == null) return;
        if (level >= levels.size()) {
            levels.add(new LinkedList<Integer>());
        }
        levels.get(level).add(root.val);
        levelHelper(root.left, level + 1, levels);
        levelHelper(root.right, level + 1, levels);
    }
}
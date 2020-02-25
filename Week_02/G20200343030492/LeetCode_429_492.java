package Week_02.G20200343030492;
import java.util.*;
/**
 * LeetCode_429_492
 */
public class LeetCode_429_492 {

	/**
	 * 递归法，时间复杂度：O(n)，空间复杂度：O(logn)
	 */
	public List<List<Integer>> levelOrder(Node root) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        levor(Arrays.asList(root), res);
        return res;
        
    }

    private void levor(List<Node> levelNodes, List<List<Integer>> res) {
        if (levelNodes == null || levelNodes.size() == 0) return;
        List<Integer> levelInts = new ArrayList<>(levelNodes.size());
        List<Node> nextLevelNodes = new ArrayList<>();
        for (Node n : levelNodes) {
            levelInts.add(n.val);
            nextLevelNodes.addAll(n.children);
        }
        res.add(levelInts);
        levor(nextLevelNodes, res);
	}

	/**
	 * 使用队列来实现。时间复杂度：O(n)，空间复杂度：O(n)
	 */
	public List<List<Integer>> levelOrder(Node root) {
        if (root == null) return new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        q.add(root);
        while (!q.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Node n = q.remove();
                level.add(n.val);
                q.addAll(n.children);
            }
            res.add(level);
        }
        return res;
    }
	
	
}
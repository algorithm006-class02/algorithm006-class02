package Week_02.G20200343030492;

import java.util.*;

/**
 * LeetCode_590_492
 */
public class LeetCode_590_492 {

	/**
	 * 递归法
	 * @param root
	 * @return
	 */
	public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<>();
        postOr(root, res);
        return res;
    }

    private void postOr(Node node, List<Integer> res) {
        if (node == null) return;
        for (Node n : node.children) {
            postOr(n, res);
        }
        res.add(node.val);
        return;
	}
	
	/**
	 * 迭代法
	 */
	public List<Integer> postorder(Node root) {
        if (root == null) return new ArrayList<>();
        Stack<Node> s = new Stack<>();
        LinkedList<Integer> res = new LinkedList<>();
        s.push(root);
        while (!s.isEmpty()) {
            Node n = s.pop();
            res.addFirst(n.val);
            for (Node c : n.children) {
                s.push(c);
            }
        }
        return res;
    }
}
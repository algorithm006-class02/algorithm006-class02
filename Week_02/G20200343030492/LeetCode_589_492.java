package Week_02.G20200343030492;

/**
 * LeetCode_589_492
 */
public class LeetCode_589_492 {

	/**
	 * 递归法
	 */
	public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        preor(root, res);
        return res;
    }

    public void preor(Node root, List<Integer> res) {
        if (root == null) return;
        res.add(root.val);
        for (Node n : root.children) {
            preor(n, res);
        }
	}
	
	/**
	 * 迭代法
	 */
	public List<Integer> preorder(Node root) {
        if (root == null) return new ArrayList<>();
        Stack<Node> s = new Stack<>();
        List<Integer> res = new ArrayList<>();
        s.push(root);
        while (!s.isEmpty()) {
            Node n = s.pop();
            res.add(n.val);
            Collections.reverse(n.children);
            for (Node c : n.children) {
                s.push(c);
            }
        }
        return res;
    }
}
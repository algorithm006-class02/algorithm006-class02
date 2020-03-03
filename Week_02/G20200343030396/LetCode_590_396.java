/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
	public List<Integer> postorder(Node root) {

		List<Integer> result = new ArrayList<>();
		_recursion(result, root);
		return result;
	}

	private void _recursion(List<Integer> result, Node node) {
        if (node == null) {
			return;
		}
		if (node.children.isEmpty()) {
			result.add(node.val);
			return;
		}

		for(Node c : node.children) {
			_recursion(result, c);
		}
        result.add(node.val);
	}
}
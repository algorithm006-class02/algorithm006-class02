class Solution {
    class NodeTraversalCount {
        public int traversalCount;
        public Node node;

        public NodeTraversalCount(int _traversalCount, Node _node) {
            traversalCount = _traversalCount;
            node = _node;
        }
    }

    public List<Integer> postorder(Node root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<NodeTraversalCount> stack = new Stack<>();

        Node currentNode = root;
        while (currentNode != null) {
            if (currentNode.children == null || currentNode.children.size() == 0) {
                result.add(currentNode.val);
                while (stack.isEmpty() == false && stack.peek().traversalCount == stack.peek().node.children.size() - 1) {
                    result.add(stack.pop().node.val);
                }
                if (stack.isEmpty() == false) {
                    currentNode = stack.peek().node.children.get(++stack.peek().traversalCount);
                } else {
                    currentNode = null;
                }
            } else {
                stack.push(new NodeTraversalCount(0, currentNode));
                currentNode = currentNode.children.get(0);
            }
        }
        return result;
    }
}
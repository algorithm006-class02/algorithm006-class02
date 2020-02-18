class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (stack.isEmpty() == false) {
            Node node = stack.pop();
            result.add(node.val);
            for (int i = node.children.size() - 1; i > -1; i--) {
                stack.add(node.children.get(i));
            }
        }
        return result;
    }
}
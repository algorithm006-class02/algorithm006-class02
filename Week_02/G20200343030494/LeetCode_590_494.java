public List<Integer> postorder(Node root) {
    LinkedList<Node> stack = new LinkedList<>();
    LinkedList<Integer> output = new LinkedList<>();
    if (root == null) {
        return output;
    }

    stack.add(root);
    while (!stack.isEmpty()) {
        Node node = stack.pollLast();
        output.addFirst(node.val);
        for (Node item : node.children) {
            if (item != null) {
                stack.add(item);
            }
        }
    }
    return output;
}
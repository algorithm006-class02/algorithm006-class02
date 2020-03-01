class Solution {
    public List<Integer> postorder(Node root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        Stack<Node> stack = new Stack<>();
        stack.add(root);
        while(!stack.isEmpty()) {
            root = stack.pop();
            list.add(root.val);
            for(Node node: root.children)
                stack.add(node);
        }
        Collections.reverse(list);
        return list;
    }
}
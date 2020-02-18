class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        preorder(root, result);
        return result;
    }

    private void preorder(Node root, List<Integer> list) {
        list.add(root.val);
        if (root.children != null) {
            for (Node node : root.children) {
                preorder(node, list);
            }
        }
    }
}
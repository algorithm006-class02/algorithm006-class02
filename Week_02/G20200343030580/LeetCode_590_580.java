class Solution {
    public List<Integer> postorder(Node root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        postorder(root, result);
        return result;
    }

    private void postorder(Node root, List<Integer> list) {

        if (root.children != null) {
            for (Node node : root.children) {
                postorder(node, list);
            }
        }
        list.add(root.val);
    }
}
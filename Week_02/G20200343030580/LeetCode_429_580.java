class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        List<Integer> rootList = new ArrayList<>();
        rootList.add(root.val);
        result.add(rootList);
        levelOrder(root.children, result);
        return result;
    }

    private void levelOrder(List<Node> nodes, List<List<Integer>> list) {
        if (nodes == null || nodes.size() == 0) {
            return;
        } else {
            List<Node> nextLevelNodes = new ArrayList<>();
            List<Integer> currentLevelValue = new ArrayList<>();
            for (Node node : nodes) {
                if (node.children != null) {
                    nextLevelNodes.addAll(node.children);
                }
                currentLevelValue.add(node.val);
            }
            list.add(currentLevelValue);
            levelOrder(nextLevelNodes, list);
        }
    }
}
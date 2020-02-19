class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> iot = inorderTraversal(root, map);
        int pIndex = map.get(p.val);
        int qIndex = map.get(q.val);
        int max = Math.max(pIndex, qIndex);
        int min = Math.min(pIndex, qIndex);
        return lowestCommonAncestor(root, map, max, min);
    }

    private TreeNode lowestCommonAncestor(TreeNode root, Map<Integer, Integer> map, int max, int min) {
        int rootIndex = map.get(root.val);
        if (rootIndex >= min && rootIndex <= max) {
            return root;
        } else if (rootIndex < min) {
            return lowestCommonAncestor(root.right, map, max, min);
        } else if (rootIndex > max) {
            return lowestCommonAncestor(root.left, map, max, min);
        }
        return null;
    }

    private List<Integer> inorderTraversal(TreeNode root, Map<Integer, Integer> map) {
        List<Integer> list = new ArrayList<>();
        inorderTraversal(root, list, map);
        return list;
    }

    private void inorderTraversal(TreeNode root, List<Integer> list, Map<Integer, Integer> map) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left, list, map);
        list.add(root.val);
        map.put(root.val, list.size() - 1);
        inorderTraversal(root.right, list, map);
        return;
    }
}
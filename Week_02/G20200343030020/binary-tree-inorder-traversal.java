class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        // 左、根、右
        List<Integer> list = new ArrayList<>();
        forEach(root, list);
        return list;
    }

    public void forEach(TreeNode root, List<Integer> list) {
        if (root != null) {
            if (root.left != null) {
                forEach(root.left, list);
            }
            list.add(root.val);
            if (root.right != null) {
                forEach(root.right, list);
            }
        }
    }
}

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty) {
            while (cur != null) {
                stack.add(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            list.add(cur.val);
            cur = cur.right;
        }
        return list;
    }
}


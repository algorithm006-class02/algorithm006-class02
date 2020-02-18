class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode currentNode = root;
        while (currentNode != null) {
            result.add(currentNode.val);
            if (currentNode.left != null) {
                stack.push(currentNode);
                currentNode = currentNode.left;
            } else if (currentNode.right != null) {
                currentNode = currentNode.right;
            } else {
                while (stack.isEmpty() == false && stack.peek().right == null) {
                    stack.pop();
                }
                if (stack.isEmpty() == false) {
                    currentNode = stack.pop().right;
                } else {
                    currentNode = null;
                }
            }
        }
        return result;
    }
}
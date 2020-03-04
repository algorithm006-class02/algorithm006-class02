class TreeNode {
    int val;
    TreeNode right;
    TreeNode left;

    TreeNode(int x) {
        val = x;
    }
}

//根、左、右
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        LinkedList<Integer> output = new LinkedList<Integer>();
        if (root == null) {
            return output;//空树
        }
        stack.add(root);//压栈、根
        while (!stack.isEmpty()) {
            TreeNode node = stack.pollLast(); //弹出栈顶元素
            output.add(node.val);
            if (node.right != null) {
                stack.add(node.right);
            }
            if (node.left != null) {
                stack.add(node.left);
            }
        }
        return output;
    }
}

//method 1
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        LinkedList<Integer> pre = new LinkedList<Integer>();
        if (root == null) return pre;
        pre.add(root.val);
        pre.addAll(preorderTraversal(root.left));
        pre.addAll(preorderTraversal(root.right));
        return pre;
    }
}

//method 2
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        LinkedList<Integer> linkedList = new LinkedList<Integer>();
        preHelper(root, linkedList);
        return linkedList;
    }

    //辅助函数
    public void preHelper(TreeNode root, List<Integer> pre) {
        if (root == null) return;
        pre.add(root.val);
        pre.addAll(root.left, pre);
        pre.addAll(root.right, pre);
    }
}

//method 3
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        Linkedlist<Integer> pre = new LinkedList<>(Integer);
        if (root == null) return pre;//是否为空树
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while (!stack.empty()) { //遍历栈
            TreeNode visiting = stack.pop();
            pre.add(visiting.val);
            if (visiting.left != null) stack.push(visiting.left);
            if (visiting.right != null) stack.push(visiting.right);

        }
        return pre;
    }
}
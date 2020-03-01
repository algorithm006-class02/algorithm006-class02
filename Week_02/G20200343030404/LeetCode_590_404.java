/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
//    public List<Integer> postorder(Node root) {
//        private List<Integer> result = new LinkedList<Integer>();
//
//        public List<Integer> postorder(Node root) {
//            if (root == null) {
//                return result;
//            }
//            if (root.children == null || root.children.size() == 0) {
//                result.add(root.val);
//                return result;
//            }
//
//            for(Node node : root.children) {
//                postorder(node);
//            }
//
//            result.add(root.val);
//            return result;
//        }
//    }

    public List<Integer> postorder(Node root) {
        LinkedList<Node> stack = new LinkedList<Node>();
        LinkedList<Integer> result = new LinkedList<Integer>();
        Node cur = null;
        List<Node> children = null;
        if (root == null) {
            return result;
        }
        stack.push(root);

        while(!stack.isEmpty()) {
            cur = stack.pop();
            result.push(cur.val);
            children = cur.children;
            if(children != null && children.size() > 0) {
                for(Node child : children) {
                    stack.push(child);
                }
            }
        }

        return result;
    }
}
class Solution {

    public List<Integer> preorder(Node root) {
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
            if (cur != null) {
                result.add(cur.val);
                children = cur.children;
                if (children != null && children.size() > 0) {
                    for(int i = children.size() - 1 ; i >= 0 ; i --) {
                        stack.push(children.get(i));
                    }
                }
            }
        }

        return result;
    }
}
//class Solution {
//    private List<Integer> result = new LinkedList<Integer>();
//
//    public List<Integer> preorder(Node root) {
//        if (root == null) {
//            return result;
//        }
//
//        if (root.children == null || root.children.size() == 0) {
//            result.add(root.val);
//            return result;
//        }
//
//        result.add(root.val);
//        for(Node child : root.children) {
//            preorder(child);
//        }
//
//        return result;
//    }
//}
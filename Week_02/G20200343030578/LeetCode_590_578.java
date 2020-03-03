//给定一个 N 叉树，返回其节点值的后序遍历。
//
// 例如，给定一个 3叉树 :
//
//
//
//
//
//
//
// 返回其后序遍历: [5,6,3,2,4,1].
//
//
//
// 说明: 递归法很简单，你可以使用迭代法完成此题吗? Related Topics 树


import java.util.ArrayList;
import java.util.List;


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
class Solution590 {

    private List<Integer> result = new ArrayList<>();

    public List<Integer> postorder(Node root) {

        postOrderRecursive(root);

        return result;
    }

    private void postOrderRecursive(Node root) {
        if(root != null){
            if(root.children.size() != 0){
                for (Node child: root.children) {
                    postOrderRecursive(child);
                }
            }

            result.add(root.val);
        }
    }
}

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author:
 * @Date: 2020-02-23 22:20
 * @Copyright: 2019 www.lenovo.com Inc. All rights reserved.
 */
public class LeetCode_429_490 {

    private List<List<Integer>> result = new LinkedList<>();

    public List<List<Integer>> levelOrder(Node root) {
        if (root == null) {
            return result;
        }
        levelOrderRecursion(root, 0);
        return result;
    }


    public List<List<Integer>> levelOrderLoop(Node root) {
        if(root == null ){
            return result;
        }

        List<Node> preLevelNode = Arrays.asList(root);

        while(!preLevelNode.isEmpty()) {
            List<Node> currentLevelNode = new LinkedList<>();
            List<Integer> preLevelVal = new LinkedList<>();
            for(Node preNode : preLevelNode) {
                preLevelVal.add(preNode.val);
                if(preNode.children != null) {
                    currentLevelNode.addAll(preNode.children);
                }
            }
            result.add(preLevelVal);
            preLevelNode = currentLevelNode;
        }

        return result;
    }

    private void levelOrderRecursion(Node current, int level) {
        if (result.size() <= level) {
            result.add(new LinkedList<Integer>());
        }
        result.get(level).add(current.val);
        List<Node> childrenList = current.children;
        if (childrenList != null) {
            childrenList.forEach(children -> {
                levelOrderRecursion(children, level + 1);
            });
        }

    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}

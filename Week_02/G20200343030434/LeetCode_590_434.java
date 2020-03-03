package algorithm.leetCode.week02.No590;

import java.util.*;

/**
 * @author ltw
 * on 2020-02-19.
 */
public class Solution {
    List<Integer> list = new ArrayList<>();

    public List<Integer> postorder(Node root) {
        if (root == null) {
            return list;
        }
        if (root.children != null) {
            for (Node node : root.children) {
                postorder(node);
            }
        }
        list.add(root.val);
        return list;
    }

//    //solution2:
//    public List<Integer> postorder(Node root) {
//
//        List<Integer> list = new LinkedList<>();
//        if (root == null)
//            return list;
//        Stack<Node> s1 = new Stack<>();
//        s1.add(root);
//        while (!s1.isEmpty()) {
//            Node cur = s1.pop();
//            list.add(0, cur.val);
//            //s2.add(cur);
//            for (Node children : cur.children) {
//                s1.add(children);
//            }
//        }
//        return list;
//    }


}


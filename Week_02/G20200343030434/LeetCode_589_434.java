package algorithm.leetCode.week02.No589;


import java.util.ArrayList;
import java.util.List;

/**
 * @author ltw
 * on 2020-02-23.
 */
public class Solution {
    List<Integer> list = new ArrayList<>();

    public List<Integer> preorder(Node root) {
        if (root == null) {
            return list;
        }
        list.add(root.val);
        if (root.children != null) {
            for (Node node : root.children) {
                preorder(node);
            }
        }
        return list;
    }

    //todo 迭代 有待补充
}


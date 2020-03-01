package G20200343030448;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class LeetCode_429_448 {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> levelOrder(Node root) {
        if (root != null) {
            traverseLevel(root, 0);
        }
        return result;
    }
    private void traverseLevel(Node root, int level) {
        if (result.size() <= level) {
            result.add(new ArrayList<>());
        }
        result.get(level).add(root.val);
        for (Node n : root.children) {
            traverseLevel(n, level + 1);
        }
    }
}

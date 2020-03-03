package com.example.lib;

import java.util.ArrayList;
import java.util.List;

/**
 * 所属项目:JavaProject
 * 所属类名:com.example.lib.LeetCode_590_376
 * 功能描述:
 * 创建作者:VVs
 * 创建时间:2020/2/23
 */

public class LeetCode_590_376 {

    public List<Integer> postorder(Node root) {

        List<Integer> res = new ArrayList<>();

        helper(root,res);

        return res;
    }

    private void helper(Node root, List<Integer> res) {
        if (root==null) return;

        for (int i = 0; i < root.children.size()-1; i++) {
            helper(root.children.get(i),res);
        }

        res.add(root.val);
    }


}

class Node{

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

}

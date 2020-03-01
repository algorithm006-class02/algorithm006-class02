package com.example.lib;

import java.util.ArrayList;
import java.util.List;

/**
 * 所属项目:JavaProject
 * 所属类名:com.example.lib.LeetCode_589_376
 * 功能描述:
 * 创建作者:VVs
 * 创建时间:2020/2/23
 */

public class LeetCode_589_376 {

    public List<Integer> preorder(TreeNode2 root) {

        List<Integer> res=new ArrayList<>();

        help(root,res);

        return res;

    }

    private void help(TreeNode2 root, List<Integer> res) {
        if (root==null) return ;

        res.add(root.val);

        for (TreeNode2  node:root.children ){
            help(root,res);
        }

    }


}

class TreeNode2{
    public int val;
    public List<TreeNode2> children;

    public TreeNode2() {}

    public TreeNode2(int _val) {
        val = _val;
    }

    public TreeNode2(int _val, List<TreeNode2> _children) {
        val = _val;
        children = _children;
    }
}

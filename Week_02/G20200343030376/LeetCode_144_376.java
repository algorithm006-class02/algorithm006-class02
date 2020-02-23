package com.example.lib;

import java.util.ArrayList;
import java.util.List;

/**
 * 所属项目:JavaProject
 * 所属类名:com.example.lib.LeetCode_144_376
 * 功能描述:
 * 创建作者:VVs
 * 创建时间:2020/2/23
 */

public class LeetCode_144_376 {

    public List<Integer> preorderTraversal(TreeNode144 root) {

        List res=new ArrayList();

        preorder(root,res);

        return res;

    }

    private void preorder(TreeNode144 root, List res) {
        if (root==null) return;
        res.add(root.val);
        preorder(root.left,res);
        preorder(root.right,res);
    }


}

class TreeNode144{
    TreeNode144 left;
    TreeNode144 right;
    int val;
    TreeNode144(int x){val=x;}

}

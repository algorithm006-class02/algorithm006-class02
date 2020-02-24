package com.example.lib;

import java.util.ArrayList;
import java.util.List;

/**
 * 所属项目:JavaProject
 * 所属类名:com.example.lib.LeetCode_94_376
 * 功能描述: LeetCode 94题 二叉数 中序遍历
 * 创建作者:VVs
 * 创建时间:2020/2/23
 */



public class LeetCode_94_376 {
    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> res= new ArrayList<>();

        inorder(root,res);

        return res;
    }

    private void inorder(TreeNode root, List<Integer> res) {

        if (root!=null){
            if (root.left!=null){
                inorder(root.left,res);
            }
            res.add(root.val);
            if (root.right!=null){
                inorder(root.right,res);
            }




        }

    }

}

 class TreeNode {
     int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

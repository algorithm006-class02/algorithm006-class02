package com.example.lib;

import java.util.ArrayList;
import java.util.List;

/**
 * 所属项目:JavaProject
 * 所属类名:com.example.lib.LeetCode_429_376
 * 功能描述:
 * 创建作者:VVs
 * 创建时间:2020/2/23
 */

public class LeetCode_429_376 {

    public List<List<Integer>> levelOrder(Node429 root) {

        List<List<Integer>> res=new ArrayList<>();

        helper(root,res,0);

        return res;

    }

    private void helper(Node429 root, List<List<Integer>> res,int level) {

        //递归终结条件
        if (root==null) {
            return;
        }

        //处理当前层的逻辑
        if(level>=res.size()){
            res.add(new ArrayList());
        }
        res.get(level).add(root.val);

        //下探到下一层
        for ( Node429 node: root.children) {

            helper(node,res,level+1);

        }

    }


}

class Node429{
    public int val;
    public List<Node429> children;

    public Node429() {}

    public Node429(int _val) {
        val = _val;
    }

    public Node429(int _val, List<Node429> _children) {
        val = _val;
        children = _children;
    }
}

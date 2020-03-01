<?php
/**
 * Definition for a binary tree node.
 * class TreeNode {
 *     public $val = null;
 *     public $left = null;
 *     public $right = null;
 *     function __construct($value) { $this->val = $value; }
 * }
 */

/**
 * 给定一个二叉树，返回它的 前序 遍历。
 */
class Solution
{
    /**
     * 解法一：递归
     * @param  {TreeNode} $root
     * @return {Integer} []
     */
    function preorderTraversal($root)
    {
        $box = [];
        return $this->travelNode($root, $box);
    }

    function travelNode($node, &$box)
    {
        if ($node) {
            $box[] = $node->val;
            $this->travelNode($node->left, $box);
            $this->travelNode($node->right, $box);
        }
        return $box;
    }

    /**
     * 解法二：迭代
     * @param  {TreeNode} $root
     * @return {Integer} []
     */
    function proorderTraversal2($root)
    {
        $output = [];
        $queue = [$root];
        if ($root == null) {
            return $output;
        }
        while ($queue) {
            $node = array_pop($queue);
            $output[] = $node->val;
            if ($node->right) array_push($queue, $node->left);
            if ($node->left) array_push($queue, $node->right);
        }
        return $output;
    }
}
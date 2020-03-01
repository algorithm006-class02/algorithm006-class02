package xmaths

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

/*
 * @lc app=leetcode.cn id=144 lang=golang
 *
 * [144] 二叉树的前序遍历
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */

func preorderTraversal(root *TreeNode) []int {
	if root == nil {
		return nil
	}
	var res []int
	buf := []*TreeNode{root}
	for len(buf) > 0 {
		p := buf[len(buf)-1]
		buf = buf[0 : len(buf)-1]
		res = append(res, p.Val)
		if p.Right != nil {
			buf = append(buf, p.Right)
		}
		if p.Left != nil {
			buf = append(buf, p.Left)
		}
	}

	return res
}

// @lc code=end

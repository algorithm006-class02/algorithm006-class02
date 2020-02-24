package xmaths

/*
 * @lc app=leetcode.cn id=236 lang=golang
 *
 * [236] 二叉树的最近公共祖先
 */

// @lc code=start
/**
 * Definition for TreeNode.
 * type TreeNode struct {
 *     Val int
 *     Left *ListNode
 *     Right *ListNode
 * }
 */
func lowestCommonAncestor(root, p, q *TreeNode) *TreeNode {
	if root == p || root == q || root == nil { // 找到了一个节点，返回那个节点，或者找到了叶子节点，直接返回
		return root
	}
	l := lowestCommonAncestor(root.Left, p, q) // 如果该子树下包含要找的节点，那么返回该节点地址，否则返回 nil
	r := lowestCommonAncestor(root.Right, p, q)
	if l != nil && r != nil {
		return root
	} else if l != nil {
		return l
	} else if r != nil {
		return r
	}
	return nil
}

// @lc code=end

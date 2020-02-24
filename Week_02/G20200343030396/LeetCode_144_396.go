package main

type TreeNode struct {
	Val int
	Left *TreeNode
	Right *TreeNode
}

/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func preorderTraversal(root *TreeNode) []int {
	result := make([]int, 0, 0)
	_preorderTraversal(&result, root)
	return result
}

func _preorderTraversal(result *[]int, root *TreeNode) {
	if root == nil {
		return
	}

	*result = append(*result, root.Val)
	_preorderTraversal(result, root.Left)
	_preorderTraversal(result, root.Right)
}


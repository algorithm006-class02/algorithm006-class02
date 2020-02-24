package main

func main() {

}

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

	if root == nil {
		return nil
	}

	var result []int

	//1. 递归
	//result = append(result, root.Val)
	//result = append(result, preorderTraversal(root.Left)...)
	//result = append(result, preorderTraversal(root.Right)...)

	//2.
	// a: 栈应用，先推入右子树，再推入左子树；
	// b: 然后出栈，继续a步骤
	stack := []*TreeNode{root}
	var top *TreeNode
	for len(stack) > 0 {
		top = stack[len(stack)-1]
		stack = stack[:len(stack)-1]
		result = append(result, top.Val)

		if top.Right != nil {
			stack = append(stack, top.Right)
		}
		if top.Left != nil {
			stack = append(stack, top.Left)
		}
	}

	return result
}
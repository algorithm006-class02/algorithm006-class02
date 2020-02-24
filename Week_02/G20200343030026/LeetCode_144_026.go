func preorderTraversal(root *TreeNode) []int {
	var result []int

	var helper func(root *TreeNode)
	helper = func(root *TreeNode) {
		if root == nil {
			return
		} else {
			result = append(result, root.Val)
			helper(root.Left)
			helper(root.Right)
		}
	}
	helper(root)

	return result
}

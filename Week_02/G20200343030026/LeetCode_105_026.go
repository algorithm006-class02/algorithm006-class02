func buildTree(preorder []int, inorder []int) *TreeNode {
	// terminale
	if len(inorder) == 0 {
		return nil
	}

	// process
	root := &TreeNode{
		Val:   preorder[0],
		Left:  nil,
		Right: nil,
	}

	// recursion
	var mid int
	for i, v := range inorder {
		if v == root.Val {
			mid = i
		}
	}
	root.Left = buildTree(preorder[1:mid+1], inorder[:mid])
	root.Right = buildTree(preorder[mid+1:], inorder[mid+1:])

	// clear
	return root
}

package main

func main() {

}

func lowestCommonAncestor(root, p, q *TreeNode) *TreeNode {

	if root == nil || root == p || root == q{
		return root
	}

	left := lowestCommonAncestor(root.Left, p, q)
	right := lowestCommonAncestor(root.Right, p, q)

	if left != nil && right != nil { //左右子树各包含一个目标值
		return root
	} else if left != nil { //左子树包含两个目标值
		return left
	} else { //右子树包含两个目标值
		return right
	}
}
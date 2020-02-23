package main

func main() {

}

//思想：递归 根据先序根节点把中序分成左右子树，如此递归下去，直到中序列表为空
func buildTree(preorder []int, inorder []int) *TreeNode {

	if len(inorder) == 0 {
		return nil
	}

	//1. 当前根节点赋值
	currentNode := TreeNode{Val:preorder[0]}
	mid := indexOf(preorder[0], inorder) //确定左子树的数量

	//2. 构建左子树  前序的[1,mid+1)为左子树，中序的[0,mid)为左子树
	currentNode.Left = buildTree(preorder[1:mid+1], inorder[:mid])

	//3. 构建右子树  前序的[mid+1, last]为右子树，中序的[mid+1,last]为右子树
	currentNode.Right = buildTree(preorder[mid+1:], inorder[mid+1:])

	return &currentNode
}

//根据value来获取index
func indexOf(element int, data []int) int {
	for k, v := range data {
		if element == v {
			return k
		}
	}
	return -1    //not found.
}
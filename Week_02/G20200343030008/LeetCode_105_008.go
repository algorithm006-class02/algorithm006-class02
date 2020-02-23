//根据一棵树的前序遍历与中序遍历构造二叉树。
//
// 注意:
//你可以假设树中没有重复的元素。
//
// 例如，给出
//
// 前序遍历 preorder = [3,9,20,15,7]
//中序遍历 inorder = [9,3,15,20,7]
//
// 返回如下的二叉树：
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// Related Topics 树 深度优先搜索 数组

package main

func main() {

}

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */

/*
// 方法一
func buildTree(preorder []int, inorder []int) *TreeNode {
	m := make(map[int]int)
	for k, v := range inorder {
		m[v] = k
	}

	pre_idx := 0

	var helper func(in_left, in_right int) *TreeNode
	helper = func(in_left, in_right int) *TreeNode {
		// 退出条件
		if in_left == in_right {
			return nil
		}
		// 从先序遍历取元素做 root
		root_val := preorder[pre_idx]
		root := &TreeNode{Val: root_val}

		// 获取中序遍历，根节点索引
		index := m[root_val]

		// 递归
		pre_idx++
		root.Left = helper(in_left, index)
		root.Right = helper(index+1, in_right)

		// 收尾
		return root
	}

	return helper(0, len(preorder))
}
*/

// 方法二
func buildTree(preorder []int, inorder []int) *TreeNode {
	if len(preorder) == 0 {
		return nil
	}
	root := &TreeNode{preorder[0], nil, nil}
	idx := searchIdx(inorder, preorder[0])
	if idx == -1 {
		return nil
	}
	root.Left = buildTree(preorder[1:idx+1], inorder[:idx])
	root.Right = buildTree(preorder[idx+1:], inorder[idx+1:])
	return root
}

func searchIdx(nums []int, val int) int {
	for i, v := range nums {
		if v == val {
			return i
		}
	}
	return -1
}

//leetcode submit region end(Prohibit modification and deletion)

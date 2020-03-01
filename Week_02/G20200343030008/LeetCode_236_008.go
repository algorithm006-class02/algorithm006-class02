// 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
//
// 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（
// 一个节点也可以是它自己的祖先）。”

// 示例 1:
// 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
// 输出: 3
// 解释: 节点 5 和节点 1 的最近公共祖先是节点 3。

// 示例 2:
// 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
// 输出: 5
// 解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。

// 说明:
// 所有节点的值都是唯一的。
// p、q 为不同节点且均存在于给定的二叉树中。
//
// Related Topics 树

package main

func main() {

}

// leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for TreeNode.
 * type TreeNode struct {
 *     Val int
 *     Left *ListNode
 *     Right *ListNode
 * }
 */

/*
var ans *TreeNode

func lowestCommonAncestor(root, p, q *TreeNode) *TreeNode {
	recurseTree(root, p, q)
	return ans
}

func recurseTree(root, p, q *TreeNode) bool {
	if root == nil {
		return false
	}

	var result int
	if root == p || root == q {
		result++
	}
	if recurseTree(root.Left, p, q) {
		result++
	}
	if recurseTree(root.Right, p, q) {
		result++
	}

	if result >= 2 {
		ans = root
	}

	return result > 0
}
*/

// go 闭包写法
func lowestCommonAncestor(root, p, q *TreeNode) *TreeNode {
	var ans *TreeNode
	var dfs func(root *TreeNode) int
	dfs = func(root *TreeNode) int {
		if root == nil {
			return 0
		}
		tmp := dfs(root.Left) | dfs(root.Right)
		if root == p {
			tmp |= 1
		}
		if root == q {
			tmp |= 2
		}
		if ans == nil && tmp == 3 {
			ans = root
		}
		return tmp
	}
	dfs(root)
	return ans
}

// leetcode submit region end(Prohibit modification and deletion)

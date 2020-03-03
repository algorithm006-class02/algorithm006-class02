package xmaths

/*
 * @lc app=leetcode.cn id=102 lang=golang
 *
 * [102] 二叉树的层次遍历
 */
type TreeNode2 struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

// func TreeCreate(i int, arr []int) *TreeNode2 {
// t := &TreeNode2{nil,arr[i],nil}
// if i<len(arr) && 2*i+1 < len(arr){
// 	t.Left = TreeCreate(2*i+1,arr)
// }
// if i<len(arr) && 2*i+2 < len(arr) {
// 	t.Right = TreeCreate(2*i+2,arr)
// }
// return t
// }

// @lc code=start
/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
// func LevelOrder(root *TreeNode2) [][]int {

// }

// @lc code=end

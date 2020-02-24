package xmaths

import "fmt"

// N叉树的后序遍历

type Student struct {
	Name  string
	Age   int
	Score float32
	left  *Student
	right *Student
}

func Trans(root *Student) {
	// 前序遍历:先遍历根节点再遍历左子树，再遍历右子树
	if root == nil {
		return
	}
	fmt.Println(root)
	Trans(root.left)
	Trans(root.right)
}

func Trans1(root *Student) {
	// 中序遍历：先遍历左子树再遍历根，再遍历根节点再遍历右子树
	if root == nil {
		return
	}
	Trans1(root.left)
	fmt.Println(root)
	Trans1(root.right)
}

func Trans2(root *Student) {
	if root == nil {
		return
	}
	Trans1(root.left)
	Trans1(root.right)
	fmt.Println(root)
}

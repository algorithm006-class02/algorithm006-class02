package xmaths

import "fmt"

type Elem int

type LinkNode struct {
	Data Elem
	Next *LinkNode
}

// 生成头结点
func New() *LinkNode {
	return &LinkNode{0, nil}
}

// 在链表的第i个位置钱插入一个元素e。复杂度为O(n)
func (head *LinkNode) Insert(i int, e Elem) bool {
	p := head
	j := 1
	for nil == p || j > 1 {
		fmt.Println("pls check i:", i)
		return false
	}
	s := &LinkNode{Data: e}
	s.Next = p.Next
	p.Next = s
	return true

}

// 遍历
func (head *LinkNode) Traverse() {
	point := head.Next
	for nil != point {
		fmt.Println(point.Data)
		point = point.Next
	}
	fmt.Println("-------------done---------")
}

// 删除

func (head *LinkNode) Delete(i int) bool {
	p := head
	j := 1
	for nil != p && j < i {
		fmt.Println("pls check i:", i)
		return false
	}

	p.Next = p.Next.Next
	return true
}

// 获取链表中的第I个元素，复杂度为O(n)

func (head *LinkNode) Get(i int) Elem {
	p := head.Next
	for j := 0; j < i; j++ {
		if nil == p {
			// 返回错误
			return -100001
		}
		p = p.Next
	}
	return p.Data
}

//单链表的长度
func (head *LinkNode) Length() int {
	p := head.Next
	count := 0
	for p != nil {
		count++
		p = p.Next
	}
	return count
}

/*
 * @lc app=leetcode.cn id=21 lang=golang
 *
 * [21] 合并两个有序链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func MergeTwoLists(l1 *LinkNode, l2 *LinkNode) *LinkNode {
	if l1 == nil {
		return l2
	} else if l2 == nil {
		return l1
	}

	newNode := New()

	if l1.Length() > l2.Length() {
		i := 0
		p := l1.Next
		for p != nil {
			newNode.Insert(1, l1.Get(i))
			if i < l2.Length() {
				newNode.Insert(1, l2.Get(i))
			}
			i++
			p = p.Next
		}

	} else {
		i := 0
		p := l2.Next
		for p != nil {
			if i < l1.Length() {
				newNode.Insert(1, l1.Get(i))
			}
			newNode.Insert(1, l2.Get(i))
			i++
			p = p.Next
		}
	}

	return newNode
}

// @lc code=end

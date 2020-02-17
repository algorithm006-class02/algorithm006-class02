package main

import (
	"fmt"
)

type ListNode struct {
	Val int
	Next *ListNode
}

func main() {

	tmp := &ListNode{}
	data := tmp
	for i := 0 ; i < 10; i++ {
		tmp.Val = i
		tmp = tmp.Next
	}

	fmt.Println(data.Next)
}


func mergeTwoLists(l1 *ListNode, l2 *ListNode) *ListNode {

	if l1 == nil && l2 == nil {
		return nil
	}
	if l1 == nil {
		return l2
	}
	if l2 == nil {
		return l1
	}

	targetList := &ListNode{}
	tmpList := targetList

	for l1 != nil || l2 != nil {

		if l1 == nil {
			tmpList.Next = l2
			l2 = nil
			continue
		}

		if l2 == nil {
			tmpList.Next = l1
			l1 = nil
			continue
		}

		if l1.Val < l2.Val {
			tmpList.Next = l1
			l1 = l1.Next
		} else {
			tmpList.Next = l2
			l2 = l2.Next
		}

		tmpList = tmpList.Next
	}

	return targetList.Next
}
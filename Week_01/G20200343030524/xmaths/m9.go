package xmaths

// type Elem int

// type NewNode struct {
// 	Data Elem
// 	Next *NewNode
// }

// // 生成头结点
// func New2() *NewNode {
// 	return &NewNode{0, 3, 4, 4, nil}
// }

// // 在链表的第i个位置钱插入一个元素e。复杂度为O(n)
// func (head *NewNode) Insert(i int, e Elem) bool {
// 	p := head
// 	j := 1
// 	for nil == p || j > 1 {
// 		fmt.Println("pls check i:", i)
// 		return false
// 	}
// 	s := &NewNode{Data: e}
// 	s.Next = p.Next
// 	p.Next = s
// 	return true

// }

// // 遍历
// func (head *NewNode) Traverse() {
// 	point := head.Next
// 	for nil != point {
// 		fmt.Println(point.Data)
// 		point = point.Next
// 	}
// 	fmt.Println("-------------done---------")
// }

// // 删除

// func (head *NewNode) Delete(i int) bool {
// 	p := head
// 	j := 1
// 	for nil != p && j < i {
// 		fmt.Println("pls check i:", i)
// 		return false
// 	}

// 	p.Next = p.Next.Next
// 	return true
// }

// // 获取链表中的第I个元素，复杂度为O(n)

// func (head *NewNode) Get(i int) Elem {
// 	p := head.Next
// 	for j := 0; j < i; j++ {
// 		if nil == p {
// 			// 返回错误
// 			return -100001
// 		}
// 		p = p.Next
// 	}
// 	return p.Data
// }

// func MergeTwoLists(l1 *ListNode, l2 *ListNode) *ListNode {

// 	if l1 == nil {
// 		return l2
// 	} else if l2 == nil {
// 		return l1
// 	}

// 	var l3Fast *ListNode = nil  //新的链表第一个节点
// 	var l3Last *ListNode = nil  //新链表最后节点
// 	var newNode *ListNode = nil //新创建节点

// 	for true {
// 		//对比l1和l2当前值,取较小值,取值链表前进一步
// 		if l1.Val > l2.Val {
// 			newNode = l2
// 			l2 = l2.Next
// 		} else {
// 			newNode = l1
// 			l1 = l1.Next
// 		}

// 		//较小值链接到l3
// 		if l3Last == nil {
// 			l3Fast = newNode
// 			l3Last = newNode
// 		} else {
// 			l3Last.Next = newNode
// 			l3Last = newNode
// 		}

// 		//如果l1和l2其中一个已经遍历完,另一个剩余部分直接拼接到新链表尾部
// 		if l1 == nil {
// 			l3Last.Next = l2
// 			break
// 		} else if l2 == nil {
// 			l3Last.Next = l1
// 			break
// 		}
// 	}

// 	return l3Fast
// }

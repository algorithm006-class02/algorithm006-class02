package main

type MyCircularDeque struct {
	font *node
	rear *node
	size int
}

type node struct {
	next *node
	pre *node
	data int
	isFake bool
}

func nodeConstructor(next *node, pre *node, data int) *node {
	return &node{next, pre, data, false}
}


/** Initialize your data structure here. Set the size of the deque to be k. */
func Constructor(k int) MyCircularDeque {

	font := &node{nil,nil,0,true}
	rear := font
	return MyCircularDeque{
		font: font,
		rear: rear,
		size: k,
	}
}


/** Adds an item at the front of Deque. Return true if the operation is successful. */
func (this *MyCircularDeque) InsertFront(value int) bool {
	if this.IsFull() {
		return false
	}
	newNode := nodeConstructor(this.font, nil, value)
	if this.IsEmpty() {
		this.font = newNode
		this.font.next = this.rear
		this.rear.pre = this.font
	} else {
		this.font = newNode
		newNode.pre = this.font
	}
	this.rear.data++
	return true
}


/** Adds an item at the rear of Deque. Return true if the operation is successful. */
func (this *MyCircularDeque) InsertLast(value int) bool {
	if this.IsFull() {
		return false
	}
	if this.rear.data ==0 {
		this.InsertFront(value)
	}else {
		newNode := nodeConstructor(this.rear, this.rear.pre, value)
		this.rear.pre.next = newNode
		this.rear = newNode.next
		this.rear.pre = newNode
		this.rear.data++
	}
	return true
}


/** Deletes an item from the front of Deque. Return true if the operation is successful. */
func (this *MyCircularDeque) DeleteFront() bool {
	if this.IsEmpty() {
		return false
	}
	this.font = this.font.next
	this.rear.next = this.font
	this.font.pre = this.rear
	this.rear.data--
	return true
}


/** Deletes an item from the rear of Deque. Return true if the operation is successful. */
func (this *MyCircularDeque) DeleteLast() bool {
	if this.IsEmpty() {
		return false
	}
	if this.rear.pre.pre != nil {
		this.rear.pre.pre.next = this.rear
	}else {
		this.font = this.rear
	}
	if this.rear.pre == this.font {
		this.font = this.rear
	}
	this.rear.pre = this.rear.pre.pre
	this.rear.data--
	return true
}


/** Get the front item from the deque. */
func (this *MyCircularDeque) GetFront() int {
	if this.IsEmpty() {
		return -1
	}
	return this.font.data
}


/** Get the last item from the deque. */
func (this *MyCircularDeque) GetRear() int {
	if this.IsEmpty() {
		return -1
	}
	return this.rear.pre.data
}


/** Checks whether the circular deque is empty or not. */
func (this *MyCircularDeque) IsEmpty() bool {
	return this.rear == this.font
}


/** Checks whether the circular deque is full or not. */
func (this *MyCircularDeque) IsFull() bool {
	return this.rear.data == this.size
}


/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * obj := Constructor(k);
 * param_1 := obj.InsertFront(value);
 * param_2 := obj.InsertLast(value);
 * param_3 := obj.DeleteFront();
 * param_4 := obj.DeleteLast();
 * param_5 := obj.GetFront();
 * param_6 := obj.GetRear();
 * param_7 := obj.IsEmpty();
 * param_8 := obj.IsFull();
 */

func main() {
	myCircularDeque := Constructor(4)
	myCircularDeque.InsertFront(1)
	myCircularDeque.DeleteLast()
	println(myCircularDeque.IsFull())
	println(myCircularDeque.IsEmpty())

}

//["MyCircularDeque","insertFront","deleteLast","getRear","getFront","getFront","deleteFront","insertFront","insertLast","insertFront","getFront","insertFront"]
//[[4],[9],[],[],[],[],[],[6],[5],[9],[],[6]]
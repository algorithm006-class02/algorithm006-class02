package main

import "fmt"

func main() {

	//["MyCircularDeque","insertFront","deleteLast","getRear","getFront","getFront","deleteFront","insertFront","insertLast","insertFront","getFront","insertFront"]
	//[[4],[9],[],[],[],[],[],[6],[5],[9],[],[6]]

	obj := Constructor(4)
	fmt.Println(obj)

	fmt.Println(obj.InsertFront(9))
	fmt.Println(obj)

	fmt.Println(obj.DeleteLast())
	fmt.Println(obj)

	fmt.Println(obj.GetRear())
	fmt.Println(obj.GetFront())
	fmt.Println(obj.GetFront())

	fmt.Println(obj.DeleteFront())
	fmt.Println(obj)

	fmt.Println(obj.InsertFront(6))
	fmt.Println(obj)

	fmt.Println(obj.InsertLast(5))
	fmt.Println(obj)

	fmt.Println(obj.InsertFront(9))
	fmt.Println(obj)

	fmt.Println(obj.GetFront())

	fmt.Println(obj.InsertFront(6))
	fmt.Println(obj)

	
}

type MyCircularDeque struct {
	data []int
	size int
	frontIndex int //队列头指针 指向下一次插入位置
	lastIndex int //队列尾指针 指向下一次插入位置
}


/** Initialize your data structure here. Set the size of the deque to be k. */
func Constructor(k int) MyCircularDeque {
	return MyCircularDeque{data: make([]int, k), frontIndex:k/2-1, lastIndex:k/2, size:k}
}


/** Adds an item at the front of Deque. Return true if the operation is successful. */
func (this *MyCircularDeque) InsertFront(value int) bool {
	if this.IsFull() {
		return false
	}

	if this.frontIndex < 0 { //头部已满
		this.rightMoveOneStep() //右移一位
	}

	this.data[this.frontIndex] = value

	this.frontIndex--

	return true
}


/** Adds an item at the rear of Deque. Return true if the operation is successful. */
func (this *MyCircularDeque) InsertLast(value int) bool {

	if this.IsFull() {
		return false
	}

	if this.lastIndex > this.size - 1 { //尾部已满
		this.leftMoveOneStep() //左移一位
	}

	this.data[this.lastIndex] = value

	this.lastIndex++

	return true
}


/** Deletes an item from the front of Deque. Return true if the operation is successful. */
func (this *MyCircularDeque) DeleteFront() bool {

	if this.IsEmpty() {
		return false
	}

	this.frontIndex++
	this.data[this.frontIndex] = 0

	return true
}


/** Deletes an item from the rear of Deque. Return true if the operation is successful. */
func (this *MyCircularDeque) DeleteLast() bool {

	if this.IsEmpty() {
		return false
	}

	this.lastIndex--
	this.data[this.lastIndex] = 0

	return true
}


/** Get the front item from the deque. */
func (this *MyCircularDeque) GetFront() int {

	if this.IsEmpty() {
		return -1
	}

	return this.data[this.frontIndex+1]
}


/** Get the last item from the deque. */
func (this *MyCircularDeque) GetRear() int {

	if this.IsEmpty() {
		return -1
	}

	return this.data[this.lastIndex-1]
}


/** Checks whether the circular deque is empty or not. */
func (this *MyCircularDeque) IsEmpty() bool {

	if this.lastIndex == this.frontIndex + 1  {
		return true
	}

	return false
}


/** Checks whether the circular deque is full or not. */
func (this *MyCircularDeque) IsFull() bool {
	if this.frontIndex < 0 && this.lastIndex > this.size - 1 {
		return true
	}

	return false
}

func (this *MyCircularDeque) leftMoveOneStep() {

	for i := this.frontIndex; i < this.lastIndex-1; i++ {
		this.data[i] = this.data[i+1]
	}

	this.frontIndex--
	this.lastIndex--
}

func (this *MyCircularDeque) rightMoveOneStep() {

	for i := this.lastIndex; i > this.frontIndex+1; i-- {
		this.data[i] = this.data[i-1]
	}

	this.frontIndex++
	this.lastIndex++
}


/*
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
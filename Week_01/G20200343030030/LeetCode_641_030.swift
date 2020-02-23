/*
 * @lc app=leetcode.cn id=641 lang=swift
 *
 * [641] 设计循环双端队列
 */

// @lc code=start
class Node {
    var val: Int
    var prev: Node?
    var next: Node?
    init(_ val: Int) {
        self.val = val
    }
}

class MyCircularDeque {

    var capacity = 0
    var count = 0
    var head: Node?
    var tail: Node?
    /** Initialize your data structure here. Set the size of the deque to be k. */
    init(_ k: Int) {
        self.capacity = k
    }
    
    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    func insertFront(_ value: Int) -> Bool {
        if isFull() { return false }

        let n = Node(value)
        if head == nil {
            head = n
            tail = head
        } else {
            n.next = head
            head?.prev = n
            head = n
        }
        count += 1
        return true
    }
    
    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    func insertLast(_ value: Int) -> Bool {
        if isFull() { return false }

        let n = Node(value)
        if tail == nil {
            tail = n
            head = tail
        } else {
            tail?.next = n
            n.prev = tail
            tail = n
        }
        count += 1
        return true
    }
    
    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    func deleteFront() -> Bool {
         if isEmpty() { return false }

        head = head?.next
        head?.prev = nil
        count -= 1
        if isEmpty() { tail = nil }
        return true
    }
    
    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    func deleteLast() -> Bool {
        if isEmpty() { return false }
        tail = tail?.prev
        tail?.next = nil
        count -= 1
        if isEmpty() { head = nil }
        return true
    }
    
    /** Get the front item from the deque. */
    func getFront() -> Int {
        if isEmpty() { return -1 }
        return head!.val
    }
    
    /** Get the last item from the deque. */
    func getRear() -> Int {
        if isEmpty() { return -1 }
        return tail!.val
    }
    
    /** Checks whether the circular deque is empty or not. */
    func isEmpty() -> Bool {
        return count == 0
    }
    
    /** Checks whether the circular deque is full or not. */
    func isFull() -> Bool {
        return count == capacity
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * let obj = MyCircularDeque(k)
 * let ret_1: Bool = obj.insertFront(value)
 * let ret_2: Bool = obj.insertLast(value)
 * let ret_3: Bool = obj.deleteFront()
 * let ret_4: Bool = obj.deleteLast()
 * let ret_5: Int = obj.getFront()
 * let ret_6: Int = obj.getRear()
 * let ret_7: Bool = obj.isEmpty()
 * let ret_8: Bool = obj.isFull()
 */
// @lc code=end


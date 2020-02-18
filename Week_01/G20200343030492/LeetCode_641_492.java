package Week_01.G20200343030492;

/**
 * LeetCode_641_492
 */
public class LeetCode_641_492 {}	

/**
 * 实现方式：链表，有头尾两个哨兵节点。
 */
class MyCircularDeque {
    
    Node head, tail;
    int capacity;
    int size;

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        this.capacity = k;
        this.size = 0;
        head = new Node(0);
        tail = new Node(0);
        head.next = tail;
        tail.prev = head;
    }
    
    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if (size == capacity) {
            return false;
        }
        Node newNode = new Node(value);
        Node next = head.next;
        newNode.next = next;
        next.prev = newNode;
        newNode.prev = head;
        head.next = newNode;
        size++;
        return true;
    }
    
    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if (size == capacity) {
            return false;
        }
        Node newNode = new Node(value);
        Node prev = tail.prev;
        prev.next = newNode;
        newNode.prev = prev;
        tail.prev = newNode;
        newNode.next = tail;
        size++;
        return true;
    }
    
    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if (size == 0) {
            return false;
        }
        Node second = head.next.next;
        second.prev = head;
        head.next = second;
        size--;
        return true;
    }
    
    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if (size == 0) {
            return false;
        }
        Node secondLast = tail.prev.prev;
        secondLast.next = tail;
        tail.prev = secondLast;
        size--;
        return true;
    }
    
    /** Get the front item from the deque. */
    public int getFront() {
        return size > 0 ? head.next.val : -1;
    }
    
    /** Get the last item from the deque. */
    public int getRear() {
        return size > 0 ? tail.prev.val : -1;
    }
    
    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return size == 0;
    }
    
    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return size == capacity;
    }
}


/**
 * 实现方式：数组，front表示第一个元素所在位置，rear表示最后一个元素所在位置的下一个元素。
 */
class MyCircularDeque1 {

    int[] data;
    int capacity;
    int front;
    int rear;

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque1(int k) {
        this.capacity = k + 1;
        data = new int[capacity];
        front = 0;
        rear = 0;
    }
    
    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }
        front = (front - 1 + capacity) % capacity;
        data[front] = value;
        return true;
    }
    
    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        data[rear] = value;
        rear = (rear + 1) % capacity;
        return true;
    }
    
    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }
        front = (front + 1) % capacity;
        return true;
    }
    
    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }
        rear = (rear - 1 + capacity) % capacity;
        return true;
    }
    
    /** Get the front item from the deque. */
    public int getFront() {
        return isEmpty() ? -1 : data[front];
    }
    
    /** Get the last item from the deque. */
    public int getRear() {
        return isEmpty() ? -1 : data[(rear - 1 + capacity) % capacity];
    }
    
    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return front == rear;
    }
    
    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return (rear + 1) % capacity == front;
    }
}

class Node {
    int val;
    Node prev;
    Node next;

    public Node(int val) {
        this.val = val;
    }
}


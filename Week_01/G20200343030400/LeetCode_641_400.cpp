//641
//https://leetcode-cn.com/problems/design-circular-deque

class MyCircularDeque {

private:
    vector<int> dq;
    int head;
    int tail;
    int capacity;

public:
    /** Initialize your data structure here. Set the size of the deque to be k. */
    MyCircularDeque(int k) {
        capacity = k + 1;
        dq.assign(capacity, -1);
        head = 0;
        tail = 0;
    }
    
    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    bool insertFront(int value) {
        if (isFull())
            return false;
        head = (head - 1 + capacity) % capacity;
        dq[head] = value;
        return true;
    }
    
    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    bool insertLast(int value) {
        if (isFull())
            return false;
        dq[tail] = value;
        tail = (tail + 1) % capacity;
        return true;
    }
    
    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    bool deleteFront() {
        if (isEmpty())
            return false;
        dq[head] = -1;
        head = (head + 1) % capacity;
        return true;
    }
    
    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    bool deleteLast() {
        if (isEmpty())
            return false;
        tail = (tail - 1 + capacity) % capacity;
        dq[tail] = -1;
        return true;
    }
    
    /** Get the front item from the deque. */
    int getFront() {
        if (isEmpty())
            return -1;
        return dq[head];
    }
    
    /** Get the last item from the deque. */
    int getRear() {
        if (isEmpty())
            return -1;
        return dq[(tail - 1 + capacity) % capacity];
    }
    
    /** Checks whether the circular deque is empty or not. */
    bool isEmpty() {
        return head == tail;
    }
    
    /** Checks whether the circular deque is full or not. */
    bool isFull() {
        return head == (tail + 1) % capacity;
    }
};

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque* obj = new MyCircularDeque(k);
 * bool param_1 = obj->insertFront(value);
 * bool param_2 = obj->insertLast(value);
 * bool param_3 = obj->deleteFront();
 * bool param_4 = obj->deleteLast();
 * int param_5 = obj->getFront();
 * int param_6 = obj->getRear();
 * bool param_7 = obj->isEmpty();
 * bool param_8 = obj->isFull();
 */

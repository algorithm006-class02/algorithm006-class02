class MyCircularDeque {
private:
    struct DLNode {
        int val;
        DLNode* next;
        DLNode* prev;
        DLNode() : val(-1), next(NULL), prev(NULL) {}
        DLNode(int v) : val(v), next(NULL), prev(NULL) {}
    };
    int size;
    int capacity;
    DLNode* head;
    DLNode* tail;
public:
    /** Initialize your data structure here. Set the size of the deque to be k. */
    MyCircularDeque(int k) {
        size = 0;
        capacity = k;
        head = new DLNode();
        tail = new DLNode();
        head->next = tail;
        tail->prev = head;
    }
    
    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    bool insertFront(int value) {
        if (isFull()) return false;
        auto node = new DLNode(value);
        node->prev = head;
        node->next = head->next;
        node->next->prev = node;
        node->prev->next = node;
        ++size;
        return true;
    }
    
    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    bool insertLast(int value) {
        if (isFull()) return false;
        auto node = new DLNode(value);
        node->prev = tail->prev;
        node->next = tail;
        node->prev->next = node;
        node->next->prev = node;
        ++size;
        return true;
    }
    
    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    bool deleteFront() {
        if (isEmpty()) return false;
        auto node = head->next;
        node->next->prev = node->prev;
        node->prev->next = node->next;
        delete node;
        node = NULL;
        --size;
        return true;
    }
    
    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    bool deleteLast() {
        if (isEmpty()) return false;
        auto node = tail->prev;
        node->next->prev = node->prev;
        node->prev->next = node->next;
        delete node;
        node = NULL;
        --size;
        return true;
    }
    
    /** Get the front item from the deque. */
    int getFront() {
        return head->next->val;
    }
    
    /** Get the last item from the deque. */
    int getRear() {
        return tail->prev->val;
    }
    
    /** Checks whether the circular deque is empty or not. */
    bool isEmpty() {
        return size==0;
    }
    
    /** Checks whether the circular deque is full or not. */
    bool isFull() {
        return size==capacity;
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
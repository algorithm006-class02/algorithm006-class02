public class LeetCode_641_442 {
    private int[] data;
    private int head;
    private int tail;
    private int capacity;
    private int cnt;

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public LeetCode_641_442(int k) {
        data = new int[k];
        capacity = k;
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }

        data[head = ((head - 1 + capacity) % capacity)] = value;
        ++cnt;

        return true;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }

        data[tail] = value;
        tail = (tail + 1) % capacity;
        ++cnt;

        return true;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }

        head = (head + 1) % capacity;
        --cnt;

        return true;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }

        tail = (tail - 1 + capacity) % capacity;
        --cnt;

        return true;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        return isEmpty() ? -1 : data[head];
    }

    /** Get the last item from the deque. */
    public int getRear() {
        return isEmpty() ? -1 : data[(tail - 1 + capacity) % capacity];
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return cnt == 0;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return cnt == capacity;
    }
}

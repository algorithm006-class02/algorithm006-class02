import java.util.LinkedList;

public class LeetCode_641_590 {

    private int size;
    LinkedList<Integer> deque = new LinkedList<Integer>();

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public LeetCode_641_590(int k) {
        this.size = k;
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }
        deque.addFirst(value);
        return true;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        deque.addLast(value);
        return true;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if (getFront() != -1) {
            deque.removeFirst();
        } else {
           return false;
        }
        return true;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if (getRear() != -1) {
            deque.removeLast();

        }
        return true;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        if (deque.isEmpty()) {
            return -1;
        }
        return deque.getFirst();
    }

    /** Get the last item from the deque. */
    public int getRear() {
        if (deque.isEmpty()) {
            return -1;
        }
        return deque.getLast();
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return deque.isEmpty();
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        if (deque.size() == size) {
            return true;
        }
        return false;
    }

    /**
     * Your MyCircularDeque object will be instantiated and called as such:
     */
    public static void main(String[] args) {
        LeetCode_641_590 obj = new LeetCode_641_590(3);
        boolean param_1 = obj.insertFront(1);
        boolean param_2 = obj.insertLast(2);
        boolean param_3 = obj.deleteFront();
        boolean param_4 = obj.deleteLast();
        int param_5 = obj.getFront();
        int param_6 = obj.getRear();
        boolean param_7 = obj.isEmpty();
        boolean param_8 = obj.isFull();
        System.out.println(param_1 + "," + param_2 + "," + param_3 + "," + param_4 + "," + param_5
            + "," + param_6 + "," + param_7 + "," + param_8);
    }
}

public class LeetCode_641_378 {
    public static class MyCircularDeque {
        private int[] data;
        private int front;
        private int last;
        private int size;


        /**
         * Initialize your data structure here. Set the size of the deque to be k.
         */
        public MyCircularDeque(int k) {
            size = k + 1;
            data = new int[size];
        }

        /**
         * Adds an item at the front of Deque. Return true if the operation is successful.
         */
        public boolean insertFront(int value) {
            if (isFull())
                return false;
            front =  front == 0 ? size - 1 : front -1;
            data[front] = value;
            return true;
        }

        /**
         * Adds an item at the rear of Deque. Return true if the operation is successful.
         */
        public boolean insertLast(int value) {
            if (isFull())
                return false;
            data[last] = value;
            last = (last + 1) % size;
            return true;
        }

        /**
         * Deletes an item from the front of Deque. Return true if the operation is successful.
         */
        public boolean deleteFront() {
            if (isEmpty())
                return false;
            front = (front + 1) % size;
            return true;
        }

        /**
         * Deletes an item from the rear of Deque. Return true if the operation is successful.
         */
        public boolean deleteLast() {
            if (isEmpty())
                return false;
            last = last == 0 ? size - 1 : last -1;
            return true;
        }

        /**
         * Get the front item from the deque.
         */
        public int getFront() {
            if (isEmpty())
                return -1;
            return data[front];
        }

        /**
         * Get the last item from the deque.
         */
        public int getRear() {
            if (isEmpty())
                return -1;
            return data[last == 0 ? size - 1 : last -1];
        }

        /**
         * Checks whether the circular deque is empty or not.
         */
        public boolean isEmpty() {
            return front == last;
        }

        /**
         * Checks whether the circular deque is full or not.
         */
        public boolean isFull() {
            return (last + 1) % size == front;
        }
    }


}

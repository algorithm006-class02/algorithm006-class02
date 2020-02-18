
class MyCircularDequeWithLinkedList {
    private final LinkedList<Integer> data;
    private int maxLength;
    private int currentLength;

    public MyCircularDeque(int k) {
        data = new LinkedList<Integer>();
        maxLength = k;
        currentLength = 0;
    }

    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }

        data.addFirst(value);
        currentLength++;
        return true;
    }

    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }

        data.addLast(value);
        currentLength++;
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }

        data.removeFirst();
        currentLength--;
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }

        data.removeLast();
        currentLength--;
        return true;
    }

    public int getFront() {
        if (isEmpty()) {
            return -1;
        }

        return data.getFirst();
    }

    public int getRear() {
        if (isEmpty()) {
            return -1;
        }

        return data.getLast();
    }

    public boolean isEmpty() {
        return currentLength == 0;
    }

    public boolean isFull() {
        return currentLength == maxLength;
    }

}


class MyCircularDequeWithArray {
   private final int[] data;
   private int queueFront;
   private int queueEnd;

   public MyCircularDeque(int k) {
       data = new int[k + 1];
       queueFront = 0;
       queueEnd = 0;
   }

   public boolean insertFront(int value) {
       if (isFull()) {
           return false;
       }

       queueFront = (queueFront - 1 + data.length) % data.length;
       data[queueFront] = value;
       return true;
   }

   public boolean insertLast(int value) {
       if (isFull()) {
           return false;
       }

       data[queueEnd] = value;
       queueEnd = (queueEnd + 1) % data.length;
       return true;
   }

   public boolean deleteFront() {
       if (isEmpty()) {
           return false;
       }

       data[queueFront] = 0;
       queueFront = (queueFront + 1) % data.length;
       return true;
   }

   public boolean deleteLast() {
       if (isEmpty()) {
           return false;
       }

       queueEnd = (queueEnd - 1 + data.length) % data.length;
       data[queueEnd] = 0;
       return true;
   }

   public int getFront() {
       if (isEmpty()) {
           return -1;
       }

       return data[queueFront];
   }

   public int getRear() {
       if (isEmpty()) {
           return -1;
       }

       return data[(queueEnd - 1 + data.length) % data.length];
   }

   public boolean isEmpty() {
       return queueEnd - queueFront == 0;
   }

   public boolean isFull() {
       return (queueEnd + 1) % data.length == queueFront;
   }
}
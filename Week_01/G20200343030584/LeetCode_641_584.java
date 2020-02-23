/**
 * 641.设计实现双端队列。
 * 你的实现需要支持以下操作：
 * MyCircularDeque(k)：构造函数,双端队列的大小为k。
 * insertFront()：将一个元素添加到双端队列头部。 如果操作成功返回 true。
 * insertLast()：将一个元素添加到双端队列尾部。如果操作成功返回 true。
 * deleteFront()：从双端队列头部删除一个元素。 如果操作成功返回 true。
 * deleteLast()：从双端队列尾部删除一个元素。如果操作成功返回 true。
 * getFront()：从双端队列头部获得一个元素。如果双端队列为空，返回 -1。
 * getRear()：获得双端队列的最后一个元素。 如果双端队列为空，返回 -1。
 * isEmpty()：检查双端队列是否为空。
 * isFull()：检查双端队列是否满了。
 * <p>
 * 链接：https://leetcode-cn.com/problems/design-circular-deque
 */
public class MyCircularDeque {
    // 引入额外节点类-双指针法
    private final int capacity;
    private int size = 0;
    private Node head;
    private Node tail;

    /** Initialize your anchor structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        capacity = k;
        Node anchorHead = new Node(-1);
        Node anchorTail = new Node(-1);
        anchorHead.next = anchorTail;
        anchorTail.pre = anchorHead;
        head = anchorHead;
        tail = anchorTail;
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }
        // 插入一个新数据，要动四根指针
        Node newNode = new Node(value);

        Node next = head.next;
        next.pre = newNode;
        newNode.next = next;

        head.next = newNode;
        newNode.pre = head;

        size++;
        return true;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        Node newNode = new Node(value);

        Node pre = tail.pre;
        pre.next = newNode;
        newNode.pre = pre;

        tail.pre = newNode;
        newNode.next = tail;

        size++;
        return true;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }
        Node front = head.next;
        System.out.println("deleteFront：" + front.value);
        Node behind = front.next;

        head.next = behind;
        behind.pre = head;
        size--;
        return true;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }
        Node last = tail.pre;
        System.out.println("deleteLast：" + last.value);
        Node preLast = last.pre;

        preLast.next = tail;
        tail.pre = preLast;
        size--;
        return true;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        if (isEmpty()) {
            return -1;
        }
        return head.next.value;
    }

    /** Get the last item from the deque. */
    public int getRear() {
        if (isEmpty()) {
            return -1;
        }
        return tail.pre.value;
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return size == 0;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return size == capacity;
    }

    private static class Node {
        private int value;
        private Node pre;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
    }
}


/*
 * @lc app=leetcode.cn id=146 lang=java
 *
 * [146] LRU缓存机制
 */

// @lc code=start
import java.util.Hashtable;
class LRUCache {
    class DLinkNode {
        int key;
        int value;
        DLinkNode pre;
        DLinkNode post;
    }

    private Hashtable<Integer, DLinkNode> cache = new Hashtable<Integer, DLinkNode>();
    private int count;
    private int capacity;
    private DLinkNode head, tail;


    public LRUCache(int capacity) {
        this.count = 0;
        this.capacity = capacity;
        head = new DLinkNode();
        tail = new DLinkNode();
        head.pre = null;
        head.post = tail;
        tail.post = null;
        tail.pre = head;
    }

    private void addNode(DLinkNode node) {
        node.pre = head;
        node.post = head.post;
        head.post.pre = node;
        head.post = node;
    }

    private void removeNode(DLinkNode node) {
        DLinkNode prevNode = node.pre;
        DLinkNode nextNode = node.post;
        prevNode.post = nextNode;
        nextNode.pre = prevNode;
    }

    private void moveToHead(DLinkNode node) {
        removeNode(node);
        addNode(node);
    }

    private DLinkNode popTail() {
        DLinkNode res = tail.pre;
        removeNode(res);
        return res;
    }

    
    public int get(int key) {
        DLinkNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        this.moveToHead(node);//为了满足最近最少使用的数据结构特性 所以要挪位置
        return node.value;
    }

    public void put(int key, int value) {
        DLinkNode node = cache.get(key);
        if (node == null) {
            DLinkNode newNode = new DLinkNode();
            newNode.key = key;
            newNode.value = value;
            this.cache.put(key, newNode);
            this.addNode(newNode);
            ++count;
            if (count > capacity) {
                DLinkNode tail = this.popTail();
                this.cache.remove(tail.key);
                --count;
            }
        } else {
            node.value = value;
            this.moveToHead(node);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
// @lc code=end


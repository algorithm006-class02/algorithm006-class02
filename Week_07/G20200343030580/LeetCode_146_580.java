class LRUCache {

    private static class CacheNode {
        int key;
        int value;
        CacheNode pre;
        CacheNode next;

        CacheNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private int capacity;
    private Map<Integer, CacheNode> cache;
    private CacheNode head;
    private CacheNode tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>(this.capacity);
        this.head = new CacheNode(-1, -1);
        this.tail = new CacheNode(-1, -1);
        this.head.next = this.tail;
        this.tail.pre = this.head;
    }

    public int get(int key) {
        CacheNode node = this.cache.get(key);
        if (node == null) {
            return -1;
        } else {
            this.moveToHead(node);
            return node.value;
        }
    }

    public void put(int key, int value) {
        CacheNode node = this.cache.get(key);
        if (node != null) {
            node.value = value;
            this.moveToHead(node);
        } else {
            node = new CacheNode(key, value);
            if (this.isFull()) {
                this.removeLast();
            }
            this.addNode(node);
            this.cache.put(key, node);
        }
    }

    private boolean isFull() {
        return this.cache.size() >= this.capacity;
    }

    private void addNode(CacheNode node) {
        node.next = head.next;
        node.pre = head;
        head.next.pre = node;
        head.next = node;
    }

    private void removeNode(CacheNode node) {
        node.next.pre = node.pre;
        node.pre.next = node.next;
    }

    private void removeLast() {
        this.cache.remove(tail.pre.key);
        tail.pre = tail.pre.pre;
        tail.pre.next = tail;
    }

    private void moveToHead(CacheNode node) {
        this.removeNode(node);
        this.addNode(node);
    }
}
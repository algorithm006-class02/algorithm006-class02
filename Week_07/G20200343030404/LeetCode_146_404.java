class LRUCache {
    private int capacity = 0;
    private Map<Integer, DlNode> map = null;
    private DlNode head;
    private DlNode tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new DlNode(null, null);
        tail = new DlNode(null, null);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if(!map.containsKey(key)) {
            return -1;
        }
        DlNode node = map.get(key);
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)) {
            DlNode node = map.get(key);
            moveToHead(node);
            node.value = value;
        } else if(map.size() < capacity) {
            addHead(new DlNode(key, value));
        } else {
            removeTail();
            addHead(new DlNode(key, value));
        }
    }

    private void moveToHead(DlNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.next = head.next;
        node.prev = head;
        node.next.prev = node;
        node.prev.next = node;
    }

    private void removeTail() {
        DlNode node = tail.prev;
        if(node == head) {
            return;
        }
        node.prev.next = node.next;
        node.next.prev = node.prev;
        map.remove(node.key);
    }

    private void addHead(DlNode node) {
        node.prev = head;
        node.next = head.next;
        node.prev.next = node;
        node.next.prev = node;
        map.put(node.key, node);
    }

    class DlNode {
        DlNode prev;
        DlNode next;
        Integer key;
        Integer value;

        public DlNode(Integer key, Integer value) {
            this.key = key;
            this.value = value;
        }
    }
}
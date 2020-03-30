class LRUCache {
    
    private LinkedHashMap<Integer, Integer> cache;

    public LRUCache(int capacity) {
        cache = new LinkedHashMap(capacity, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > capacity;
            }
        };    
    }
    
    public int get(int key) {
        if (cache.containsKey(key)) {
            return cache.get(key);
        } else {
            return -1;
        }
        
    }
    
    public void put(int key, int value) {
        cache.put(key, value);
        
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

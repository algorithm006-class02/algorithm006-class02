package leetcode

//LRUCacheNode LRU缓存节点双向链表
type LRUCacheNode struct {
	key  int
	val  int
	pre  *LRUCacheNode
	next *LRUCacheNode
}

//LRUCache LRU缓存
type LRUCache struct {
	keys     map[int]*LRUCacheNode
	head     *LRUCacheNode
	tail     *LRUCacheNode
	capacity int
}

func Constructor(capacity int) *LRUCache {
	var lru LRUCache = LRUCache{
		keys:     make(map[int]*LRUCacheNode, capacity),
		head:     &LRUCacheNode{},
		tail:     &LRUCacheNode{},
		capacity: capacity,
	}
	lru.head.next = lru.tail
	lru.tail.pre = lru.head
	return &lru
}

func (this *LRUCache) Get(key int) int {
	node, err := this.keys[key]
	if !err {
		return -1
	}
	node.pre.next = node.next
	node.next.pre = node.pre
	node.next = this.head.next
	node.pre = this.head
	this.head.next = node
	node.next.pre = node
	return node.val
}

func (this *LRUCache) Put(key int, value int) {
	node, err := this.keys[key]
	if err {
		node.pre.next = node.next
		node.next.pre = node.pre
		// delete(this.keys, key)
	} else {
		if len(this.keys) == this.capacity {
			delete(this.keys, this.tail.pre.key)
			this.tail.pre.pre.next = this.tail
			this.tail.pre = this.tail.pre.pre
		}
		node = &LRUCacheNode{key: key, val: value}
		this.keys[key] = node
	}
	node.val = value
	node.next = this.head.next
	node.pre = this.head
	this.head.next = node
	node.next.pre = node
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * obj := Constructor(capacity);
 * param_1 := obj.Get(key);
 * obj.Put(key,value);
 */

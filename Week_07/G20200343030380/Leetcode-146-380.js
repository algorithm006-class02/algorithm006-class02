/**
 * 146. LRU Cache
 * https://leetcode-cn.com/problems/lru-cache/
 * 解法一：哈希表 + 双端链表
 */
class Node {
  constructor(key, val) {
    this.key = key
    this.val = val
    this.prev = null
    this.next = null
  }
}

class DoubleLink {
  constructor() {
    this.head = new Node(0, 0)
    this.tail = new Node(0, 0)
    this.head.next = this.tail
    this.tail.prev = this.head
  }
  insertFirst(node) {
    node.next = this.head.next
    node.prev = this.head
    this.head.next.prev = node
    this.head.next = node
  }
  remove(node) {
    node.prev.next = node.next    
    node.next.prev = node.prev
  }
  removeLast() {
    if (this.tail.prev === this.head) return null
    let last = this.tail.prev
    this.remove(last)
    return last
  }
}

var LRUCache = function(capacity) {
  this.capacity = capacity
  this.map = new Map()
  this.link = new DoubleLink()
}

LRUCache.prototype.get = function(key) {
  if (!this.map.has(key)) return -1
  let val = this.map.get(key).val
  this.put(key, val)
  return val
}

LRUCache.prototype.put = function(key, value) {
  let node = new Node(key, value)
  let currSize = this.map.size
  if (this.map.has(key)) {
    currSize--
    this.link.remove(this.map.get(key))
  }
  if (currSize >= this.capacity) {
    let last = this.link.removeLast()
    this.map.delete(last.key)
  }
  this.map.set(key, node)
  this.link.insertFirst(node)
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * var obj = new LRUCache(capacity)
 * var param_1 = obj.get(key)
 * obj.put(key,value)
 */

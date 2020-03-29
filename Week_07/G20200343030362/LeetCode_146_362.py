class Node:
    def __init__(self):
        self.key = 0
        self.value = 0
        self.pre = None
        self.next = None

class LRUCache:

    def _insertNode(self, node: Node):
        node.next = self.head.next
        node.pre = self.head
        node.next.pre = node
        self.head.next = node

    def _useNode(self, node: Node):
        node.next.pre = node.pre
        node.pre.next = node.next
        self._insertNode(node)
    
    def __init__(self, capacity: int):
        self.size = 0
        self.data = {}
        self.capacity = capacity
        self.head = Node()
        self.tail = Node()
        self.head.next = self.tail
        self.tail.pre = self.head

    def get(self, key: int) -> int:
        if key not in self.data:
            return -1
        node = self.data.get(key, None)
        self._useNode(node)
        return node.value

    def put(self, key: int, value: int) -> None:
        node = self.data.get(key)
        if node:
            node.value = value
            self._useNode(node)
        else:
            self.size += 1
            node = Node()
            node.key = key
            node.value = value
            self.data[key] = node
            self._insertNode(node)
            if self.size > self.capacity:
                self.data.pop(self.tail.pre.key)
                self.tail.pre = self.tail.pre.pre
                self.tail.pre.next = self.tail
                self.size -= 1


"""
146. LRU缓存机制
"""

from collections import OrderedDict
class LRUCache:

    def __init__(self, capacity: int):
        self.od = OrderedDict()
        self.capacity = capacity

    def get(self, key: int) -> int:
        if key not in self.od:
            return -1
        else:
            value = self.od.pop(key)
        
        self.od[key] = value
        return value

    def put(self, key: int, value: int) -> None:
        if key in self.od:
            self.od.pop(key)
        else:
            if len(self.od) >= self.capacity:
                self.od.popitem(last=False)       
        
        self.od[key]=value

        


# Your LRUCache object will be instantiated and called as such:
# obj = LRUCache(capacity)
# param_1 = obj.get(key)
# obj.put(key,value)
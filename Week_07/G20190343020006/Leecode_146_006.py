from collections import OrderedDict
class LRUCache:

    def __init__(self, capacity: int):
        self.maxsize = capacity
        self.lrucache = OrderedDict()

    def get(self, key: int) -> int:
        if key in self.lrucache:
            self.lrucache.move_to_end(key)
        return self.lrucache.get(key, -1)
           

    def put(self, key: int, value: int) -> None:
        if key in self.lrucache:
            del self.lrucache[key]
        self.lrucache[key] = value
        if len(self.lrucache) > self.maxsize:

            self.lrucache.popitem(last = False)

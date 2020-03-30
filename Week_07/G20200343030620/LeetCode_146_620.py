class ListNode:
    def __init__(self,key=None,val=None):
        self.key=key
        self.val=val
        self.next=None
        self.pre=None

class LRUCache:
    # 思路1: 使用map的存储，其中value 部分存储为（频次，value)的形式，get 操作时间复杂度为O(1),put 操作时间复杂为O(n)。 但对于该思路的改进使用有序字典进行存储orderDict
    # 思路2: 使用字典+双向链表来实现
   
    # 由于在put 和get的时都需要将该元素移动到最顶部,创建独立的一个方法
    def move_to_tail(self,key):
        node=self.dicts[key]
        node.pre.next=node.next
        node.next.pre=node.pre
        node.next=self.tail
        node.pre=self.tail.pre
        self.tail.pre.next=node
        self.tail.pre=node

    def __init__(self, capacity: int):
        self.capacity=capacity
        self.dicts={}
        self.head=ListNode
        self.tail=ListNode
        self.head.next=self.tail
        self.tail.pre=self.head

    def get(self, key: int) -> int:
        res=self.dicts.get(key,-1)
        if res!=-1:
            self.move_to_tail(key)
            return res.val
        else:
            return res 
        
    def put(self, key: int, value: int) -> None:
        if key in self.dicts:
            self.dicts[key].val=value
            self.move_to_tail(key)
        else:
            #移除最近最少没有使用的key,并将新元素插入
            if len(self.dicts)==self.capacity:
                # 删除最近最少未使用的节点
                self.dicts.pop(self.head.next.key)
                self.head.next=self.head.next.next
                self.head.next.pre=self.head     
           
            new =ListNode(key,value)
            self.dicts[key]=new
            # 插入链表
            new.next=self.tail
            new.pre=self.tail.pre
            self.tail.pre.next=new
            self.tail.pre=new
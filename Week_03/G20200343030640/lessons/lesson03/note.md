
### 单链表逆置

使用递归算法单链表逆置
```json
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    // head 指向单链表第一个节点，不带头节点
    def reverseList(self, head: ListNode) -> ListNode:
        if head is None or head.next is None:
            return head
        newhead = self.reverseList(head.next)
        head.next.next = head
        head.next = None
        return newhead
```
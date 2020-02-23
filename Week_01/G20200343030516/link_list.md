个人感觉，面试需要高度重视链表：
链表的反转，双指针，递归实现， 合并，约瑟夫环等都是重点。


个人遇到的 链表题目：

## 1 报数游戏

100个人围成一圈，每个人有一个编码，编号从1开始到100.他们从1开始依次报数，报到为M的人自动退出圈圈，然后下一个人接着从1开始报数，直到剩余的人数小于M。请问最后剩余的人在原先的编号为多少？例如输入M=3时，输出为：“58，91”，输入M=4时，输出为： “34，45， 97”。
如果m小于等于1， 则输出“ERROR!”;
如果m大于等于100，则输出“ERROR!”；

> 示例
> 输入
> 3
> 输出
> 58，91


```python
def remove_num( m, total_num=100):
    if m <= 1 or m >=100:
        return "Error"
    circle = [ _ for _ in range (1,101) ]
    cur = 0
    cur_len = len(circle)

    while cur_len >= m:
        cur = (cur + m - 1) % cur_len
        circle.remove(circle[cur])
        cur_len = len(circle)

    return circle
```

### 反转链表

解法1：
采取双指针，中间加tmp 
```python
def reverseList(self, head: ListNode) -> ListNode:
        if not head :
            return head
        pre = None
        cur  = head
        while cur:
            tmp = cur.next
            cur.next = pre
            pre,cur = cur, tmp
        return pre
```
解法二：
递归：
class Solution(object):
	def reverseList(self, head):
		"""
		:type head: ListNode
		:rtype: ListNode
		"""
		# 递归终止条件是当前为空，或者下一个节点为空
		if(head==None or head.next==None):
			return head
		# 这里的cur就是最后一个节点
		cur = self.reverseList(head.next)
		# 这里请配合动画演示理解
		# 如果链表是 1->2->3->4->5，那么此时的cur就是5
		# 而head是4，head的下一个是5，下下一个是空
		# 所以head.next.next 就是5->4
		head.next.next = head
		# 防止链表循环，需要将head.next设置为空
		head.next = None
		# 每层递归函数都返回cur，也就是最后一个节点
		return cur

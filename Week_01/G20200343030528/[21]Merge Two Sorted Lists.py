# Merge two sorted linked lists and return it as a new list. The new list should
#  be made by splicing together the nodes of the first two lists. 
# 
#  Example:
#  
# Input: 1->2->4, 1->3->4
# Output: 1->1->2->3->4->4
#  
#  Related Topics Linked List


# leetcode submit region begin(Prohibit modification and deletion)
# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    def mergeTwoLists(self, l1: ListNode, l2: ListNode) :
        if l1 and l2:
            if l1.val > l2.val: l1,l2 = l2, l1
            l1.next = self.mergeTwoLists(l1.next,l2)
        return l1 or l2

#这代码太牛了，但是有些地方不太懂。 第一行判断是否有一个为空，假设l1为空为什么会直接返回l2呢，假设l1为空，那么这段判断就不执行，直接到return l1 or l2，因为l1 为空，l2为真，由or得特性可以输出l2
# 第二行和第三行也是，如果l1 > l2,那么让l1得值链接成小得值，而l2如果大于l1，那么不执行这个判断，那么还是i维持l1 得next指针指向l2 next指针。

# leetcode submit region end(Prohibit modification and deletion)

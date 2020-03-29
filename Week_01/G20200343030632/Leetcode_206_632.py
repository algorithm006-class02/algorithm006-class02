# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def reverseList(self, head: ListNode) -> ListNode:
        return self.reverseList_v1(head)
        # return self.reverseList_v2(head)
    def reverseList_v1(self, head: ListNode) -> ListNode:
        pre = None
        cur = head
        while cur:
            temp = cur
            cur = cur.next
            temp.next = pre
            pre = temp


        return pre

    def reverseList_v2(self, head: ListNode) -> ListNode:
        return self.helper(head)
    def helper(self, node, pre = None):
        if not node:
            return pre
        
        n = node.next
        node.next = pre
        return self.helper(n, node)

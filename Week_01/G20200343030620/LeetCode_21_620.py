# Definition for singly-linked list.

class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution:
    def mergeTwoLists(self, l1: ListNode, l2: ListNode) -> ListNode:
        l3 = ListNode(-1)
        q = l3
        while l1 and l2:
            if l1.val <= l2.val:
                q.next = l1
                l1 = l1.next
            else:
                q.next = l2
                l2 = l2.next
            q = q.next
        q.next = l2 if l1 is None else l1
        return l3.next

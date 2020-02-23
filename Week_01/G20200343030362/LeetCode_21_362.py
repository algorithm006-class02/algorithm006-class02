# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    def mergeTwoLists(self, l1: ListNode, l2: ListNode) -> ListNode:
        if l1 == None:
            return l2
        if l2 == None:
            return l1
        if l1.val > l2.val:
            l2.next = self.mergeTwoLists(l2.next, l1)
            return l2
        else:
            l1.next = self.mergeTwoLists(l1.next, l2)
            return l1

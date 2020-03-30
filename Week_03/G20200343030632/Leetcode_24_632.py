# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def swapPairs(self, head: ListNode) -> ListNode:
        return self.swapPairs_v1(head)
    def swapPairs_v1(self, head: ListNode) -> ListNode:
        one, two = head, head.next
        dummy = head
        while one and one.next:
            two = one.next
            tmp = two.next
            two.next = one
            one.next = tmp
            one = tmp
            # two = tmp.next
        
        return head

    

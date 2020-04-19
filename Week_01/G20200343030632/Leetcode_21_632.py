    #
# @lc app=leetcode.cn id=21 lang=python3
#
# [21] 合并两个有序链表
#

# @lc code=start
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def mergeTwoLists(self, l1: ListNode, l2: ListNode) -> ListNode:
        # return self.mergeTwoLists_v1(l1, l2)
        return self.mergeTwoLists_v2(l1, l2)
    def mergeTwoLists_v1(self, l1: ListNode, l2: ListNode) -> ListNode:
        head = ListNode(0)
        p = head
        while l1 and l2:
            if l1.val < l2.val:
                p.next = l1
                l1 = l1.next
            else:
                p.next = l2
                l2 = l2.next
            p = p.next

        if l1: p.next = l1
        if l2: p.next = l2
        return head.next

    def mergeTwoLists_v2(self, l1: ListNode, l2: ListNode) -> ListNode:
        return self.helper(l1, l2)

    def helper(self, l1, l2):
        if not l1:
            return l2
        if not l2:
            return l1

        if l1.val < l2.val:
            l1.next = self.helper(l1.next, l2)
            return l1
        else:
            l2.next = self.helper(l1, l2.next)
            return l2

        



# @lc code=end


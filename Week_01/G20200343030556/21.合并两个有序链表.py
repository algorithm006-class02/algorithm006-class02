# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def mergeTwoLists(self, l1, l2):
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """

        # 1.迭代法
        # prehead = ListNode(-1)
        # pre = prehead
        # while l1 and l2:
        #     if l1.val < l2.val:
        #         pre.next ,l1 = l1, l1.next
        #     else:
        #         pre.next ,l2 = l2, l2.next
        #     pre = pre.next
        
        # pre.next = l1 if l1 is not None else l2
        # return prehead.next

        # 2. 递归
        if not (l1 and l2):
            return l1 if l1 is not None else l2

        while l1 and l2:
            if l1.val < l2.val:
                l1.next = self.mergeTwoLists(l1.next,l2)
                return l1
            else:
                l2.next = self.mergeTwoLists(l1,l2.next)
                return l2
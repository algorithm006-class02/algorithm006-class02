/**
 * 21. Merge Two Sorted Lists
 */

#include <stdio.h>

struct ListNode {
  int val;
  struct ListNode* next;
};

//时间复杂度O(l1.size + l2.size)
struct ListNode* mergeTwoLists(struct ListNode* l1, struct ListNode* l2) {
  if (!l1) return l2;
  if (!l2) return l1;

  struct ListNode* cur = NULL;
  if (l1->val > l2->val) {
    cur = l2;
    l2 = l2->next;
  } else {
    cur = l1;
    l1 = l1->next;
  }
  struct ListNode* rst = cur;

  while (l1 && l2) {
    if (l1->val > l2->val) {
      cur->next = l2;
      l2 = l2->next;
    } else {
      cur->next = l1;
      l1 = l1->next;
    }
    cur = cur->next;
  }

  cur->next = l1 ? l1 : l2;

  return rst;
}
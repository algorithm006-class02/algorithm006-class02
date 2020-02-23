/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution
{
public:
    ListNode *mergeTwoLists(ListNode *l1, ListNode *l2)
    {
        if (l1 == nullptr || l2 == nullptr)
        {
            return (l1 == nullptr) ? l2 : l1;
        }

        ListNode *head = new ListNode(-1);
        ListNode *iter = head;

        while (l1 != nullptr && l2 != nullptr)
        {
            if (l1->val < l2->val)
            {
                iter->next = l1;
                l1 = l1->next;
            }
            else
            {
                iter->next = l2;
                l2 = l2->next;
            }

            iter = iter->next;
        }

        if (l1 != nullptr)
        {
            iter->next = l1;
        }

        if (l2 != nullptr)
        {
            iter->next = l2;
        }

        return head->next;
    }
};
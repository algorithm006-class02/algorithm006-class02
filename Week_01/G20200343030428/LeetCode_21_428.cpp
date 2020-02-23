/*
 * @lc app=leetcode.cn id=21 lang=cpp
 *
 * [21] 合并两个有序链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
/* ----- 第一次提交 选择头节点，然后从头节点开始，往下遍历  
        时间复杂度O(1)
class Solution {
public:
    ListNode* mergeTwoLists(ListNode* l1, ListNode* l2) {
        ListNode *head = new ListNode(0);
        if (l1 == NULL) return l2;
        if (l2 == NULL) return l1;
        if (l1->val > l2->val) {
            head->val = l2->val;
            l2 = l2->next;
        }
        else {
            head->val = l1->val;
            l1 = l1->next;
        }
        ListNode* p1 = head;
        while (l1 != NULL and l2 != NULL) {
            if (l1->val < l2->val) {
                p1->next = l1;
                l1 = l1->next; 
            }
            else {
                p1->next = l2;
                l2 = l2->next; 
            }
            p1 = p1->next;
        }
        if (l1 == NULL) {
            p1->next = l2;
        } 
        else {
            p1->next = l1;
        }
        return head;
    }
};
*/
class Solution{
    public:
    ListNode* mergeTwoLists(ListNode* l1,ListNode *l2){
        if(l1 == NULL) return l2;
        else if(l2 == NULL) return l1;
        else if (l1 -> val < l2 -> val){
            l1 -> next = mergeTwoLists(l1 -> next, l2);
            return l1;
        }
        else{
            l2 -> next =mergeTwoLists(l1,l2->next);
            return l2;
        }
    }};
// @lc code=end


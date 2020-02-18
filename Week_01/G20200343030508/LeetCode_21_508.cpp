/*
 * @lc app=leetcode.cn id=21 lang=cpp
 *
 * [21] 合并两个有序链表
 *
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/description/
 *
 * algorithms
 * Easy (59.57%)
 * Likes:    852
 * Dislikes: 0
 * Total Accepted:    181.7K
 * Total Submissions: 304.7K
 * Testcase Example:  '[1,2,4]\n[1,3,4]'
 *
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 * 
 * 示例：
 * 
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * 
 * 
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
class Solution {
public:
    ListNode* mergeTwoLists(ListNode* l1, ListNode* l2) {
        if (!l1&&!l2){
            return NULL;
        }
        ListNode *first,*newNode=new ListNode(0);
        int index=0;
        while( l1!=nullptr || l2!=nullptr ) {           
            if (l1&&l2&&l1->val<=l2->val){
                newNode->next=l1;
                l1=l1->next;
            }else if(l1&&l2&&l1->val>l2->val){
                newNode->next=l2;
                l2=l2->next;
            }else{
                if(l1) {
                    newNode->next=l1;
                    l1=l1->next;
                }
                if(l2) {
                    newNode->next=l2;
                    l2=l2->next;
                }
            }            
            if (index==0) {
                first=newNode->next;
            }
            newNode=newNode->next;
            index++;
        }
        return first;
    }
};
// @lc code=end


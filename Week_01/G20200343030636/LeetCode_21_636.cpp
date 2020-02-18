/*
 * @lc app=leetcode.cn id=21 lang=cpp
 *
 * [21] 合并两个有序链表
 *
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/description/
 *
 * algorithms
 * Easy (59.53%)
 * Likes:    844
 * Dislikes: 0
 * Total Accepted:    179.9K
 * Total Submissions: 301.9K
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
    /*
    解法一：逐个比较两个链表每个节点的值，并没有考虑有一个先遍历完的情况，时间复杂度=O(max(l1.length,l2.length))
    8ms 85.29%
    */
    ListNode* mergeTwoLists(ListNode* l1, ListNode* l2) {

        //判断为空的情况
        if ( l1 == nullptr ) return l2 ;
        if ( l2 == nullptr ) return l1 ;

        //设定头节点，方便返回；
        ListNode * head = new ListNode(0) ;
        //设定当前节点，用于拼接；
        ListNode * cur = head ;

        while ( l1 != nullptr || l2 != nullptr ) {
            
            if ( l1 == nullptr  || ( l2 != nullptr && l2 -> val <= l1 -> val ) ) {
                cur -> next = l2 ;
                l2 = l2 -> next ;
            }
            else { 
                cur -> next = l1 ;
                l1 = l1 -> next ;
            }

            cur =  cur -> next ;
        }

        return head -> next ;
    } 

    /*
    解法二：思路同解法1，区别是当遍历完短的之后即可结束比较，时间复杂度=O(min(l1.length,l2.length))
    4ms 98.75% 
    */
    ListNode* mergeTwoLists(ListNode* l1, ListNode* l2) {

        //判断为空的情况
        if ( l1 == nullptr ) return l2 ;
        if ( l2 == nullptr ) return l1 ;

        //设定头节点，方便返回；
        ListNode * head = new ListNode(0) ;
        //设定当前节点，用于拼接；
        ListNode * cur = head ;

        while ( l1 != nullptr && l2 != nullptr ) {
            
            if ( l2 -> val <= l1 -> val )  {
                cur -> next = l2 ;
                l2 = l2 -> next ;
            }
            else { 
                cur -> next = l1 ;
                l1 = l1 -> next ;
            }

            cur =  cur -> next ;
        }
        cur -> next = l1 != nullptr ? l1 : l2 ;
        
        return head -> next ;
    }


    /*
    解法三：递归，但递归调用带来但开销较大。时间复杂度=O(min(l1.length,l2.length))
    12ms 46.56%
    */
    ListNode* mergeTwoLists(ListNode* l1, ListNode* l2) {
        //判断为空的情况
        if ( l1 == nullptr ) return l2 ;
        if ( l2 == nullptr ) return l1 ;

        if ( l1 -> val <= l2 -> val ) {
            l1 -> next = mergeTwoLists ( l1 -> next , l2) ;
            return l1 ;
        }
        else {
            l2 -> next = mergeTwoLists ( l1 , l2 -> next) ;
            return l2 ;
        }
   } 

};
// @lc code=end


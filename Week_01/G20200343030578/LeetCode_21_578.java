//将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
//
// 示例：
//
// 输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4
//
// Related Topics 链表


/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        // 创建带有头指针的链表，方便操作
        ListNode l3 = new ListNode(0);
        // 新建一个 p 指针用于遍历
        ListNode p = l3;

        // 循环比较，并把较小的结点加入链表 l3
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val){
                p.next = l1;
                p = p.next;
                l1 = l1.next;
            }else{
                p.next = l2;
                p = p.next;
                l2 = l2.next;
            }
        }

        // 将 l1 剩余元素加入 l3
        if(l1 != null){
            p.next = l1;
        }

        // 将 l2 剩余元素加入 l3
        if(l2 != null){
            p.next = l2;
        }


        // 删除 l3 的头指针
        return l3.next;

    }
}


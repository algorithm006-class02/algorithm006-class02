public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

//迭代
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode tmp = null;
        while (cur != null) {
            //记录当前节点的下一个节点
            tmp = cur.next;
            //当前的节点指向pre
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }
}

//进行递归
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head.next == null || head == null) return head;
        ListNode cur = reverseList(head.next);
        head.next.next = head;
        //防止死循环出现
        head.next = null;
        return cur;
    }
}
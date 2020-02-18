import Entity.ListNode;

/**
 * 反转一个单链表。
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 */
public class LeetCode_206_564 {

    public static ListNode reverseHead;

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6};
        ListNode listNode = constructListNode(nums);
//        ListNode reverseList1 = reverseList1(listNode);
//        ListNode reverseList2 = reverseList2(listNode);
        ListNode reverseList3 = reverseList3(listNode);
    }

    /**
     * 递归
     * @param head
     * @return
     */
    private static ListNode reverseList1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 记录尾链表
        ListNode newNode = head.next;
        ListNode temp = reverseList1(head.next);
        newNode.next = head;
        head.next = null;
        return temp;
    }

    /**
     * 递归
     * @param head
     * @return
     */
    private static ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newNode = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return newNode;
    }

    /**
     * 迭代
     * @param head
     * @return
     */
    private static ListNode reverseList3(ListNode head) {
        // 定义两个指针，然后交换两个链表的位置
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            // 缓存当前的节点指向的节点
            ListNode tempNode = curr.next;
            // 交换前后两个节点
            curr.next = prev;
            prev = curr;
            curr = tempNode;
        }
        return prev;
    }

    /**
     * 构建链表
     * @return
     */
    private static ListNode constructListNode(int[] nums) {
        ListNode fist = null;
        ListNode last = null;
        ListNode newNode = null;

        if (nums.length > 0) {
            for (int n : nums) {
                newNode = new ListNode(n);
                newNode.next = null;
                if (fist == null) {
                    fist = newNode;
                    last = newNode;
                } else {
                    last.next = newNode;
                    last = newNode;
                }
            }
        }
        return fist;
    }
}

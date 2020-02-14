/**
 * 21. 合并两个有序链表
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 * 示例：
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * <p>
 * 链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
 */
public class MergeSortedList {
    public static void test() {
        ListNode node = new ListNode(4);
        ListNode next = new ListNode(5);
        ListNode next2 = new ListNode(8);
        node.next = next;
        next.next = next2;

        ListNode curr = node;
        printNode(curr);

        ListNode node2 = new ListNode(2);
        ListNode next3 = new ListNode(3);
        ListNode next4 = new ListNode(9);
        next3.next = next4;
        node2.next = next3;
        curr = node2;
        printNode(curr);

        ListNode mergeTwoLists = mergeTwoLists(node, node2);
//        ListNode mergeTwoLists = mergeTwoLists2(node, node2);
        System.out.println("\n合并后：");
        printNode(mergeTwoLists);
    }

    private static void printNode(ListNode curr) {
        do {
            System.out.print(curr.val + ",");
            curr = curr.next;
        } while (curr != null);
        System.out.println("");
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 游标法
        ListNode newNode = new ListNode(-1);
        ListNode prev = newNode;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        if (l1 != null) {
            prev.next = l1;
        } else if (l2 != null) {
            prev.next = l2;
        }
        return newNode.next;
    }

    public static ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        // 递归法
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists2(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists2(l1, l2.next);
            return l2;
        }
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) { val = x; }
    }
}

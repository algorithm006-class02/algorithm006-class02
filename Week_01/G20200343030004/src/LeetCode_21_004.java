import java.util.Arrays;

public class LeetCode_21_004 {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
        @Override
        public String toString() {
          if(next != null) {
              return val+"->"+next.toString();
          } else {
              return val+"";
          }
        }
    }

    public static ListNode mergeTwoLists(ListNode listNode1, ListNode listNode2) {
        if(listNode1 == null && listNode2 == null) {
            return null;
        } else if(listNode1 == null) {
            return listNode2;
        } else if(listNode2 == null) {
            return listNode1;
        } else {
            if(listNode1.val < listNode2.val) {
                listNode1.next = mergeTwoLists(listNode1.next,listNode2);
                return listNode1;
            } else{
                listNode2.next = mergeTwoLists(listNode1,listNode2.next);
                return listNode2;
            }
        }
    }

    public static ListNode mockListNode(int startVal,int endMockVal) {
        ListNode node = new ListNode(startVal);
        if(startVal > endMockVal) {
            node.next = null;
        } else {
            node.next = mockListNode(startVal+2,endMockVal);
        }
        return node;
    }

    public static void main(String[] args) {
        ListNode node1 = mockListNode(0,20);
        System.out.println("["+node1.toString()+"]");
        ListNode node2 = mockListNode(1,21);
        System.out.println("["+node2.toString()+"]");
        System.out.println("["+mergeTwoLists(node1,node2).toString()+"]");
    }
}
